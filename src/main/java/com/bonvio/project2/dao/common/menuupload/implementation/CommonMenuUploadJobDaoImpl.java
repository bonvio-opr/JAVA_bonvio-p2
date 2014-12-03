package com.bonvio.project2.dao.common.menuupload.implementation;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.classes.common.menuupload.Ingredient;
import com.bonvio.project2.classes.common.menuupload.IngredientInRecipe;
import com.bonvio.project2.classes.common.menuupload.MenuCategory;
import com.bonvio.project2.classes.common.menuupload.MenuPositionRecipe;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.common.menuupload.CommonMenuUploadJobDao;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Arti on 12.08.2014.
 */
public class CommonMenuUploadJobDaoImpl extends BaseDao implements CommonMenuUploadJobDao {

    @Autowired
    public CommonMenuUploadJobDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public int ingredientUpload(String ingrName, String ipAddress) {
        int spotId = getCafeIdBySpotIpAddress(ipAddress);
        try {
            String q = "insert into "+defaultSchema+".s_cafe_recipes_ingredients (s_name, s_spot_id) values (?,?)";
            getJdbcTemplate().update(q, ingrName, spotId);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка: невозможно поместить в БД ингредиент: ошибка синитаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int ingredientsRemove(int ingredientId, String ipAddress) {
        try {
            int spotId = getCafeIdBySpotIpAddress(ipAddress);
            getJdbcTemplate().update("delete from s_cafe_recipes_ingredients where s_id = "+ingredientId+" and s_spot_id="+spotId);
            return 1;
        } catch(Exception e) {
            System.out.println("Ошибка удаления ингредиентов: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int addPositionWithRecipe(MenuPositionRecipe p, int spotId) {
        try {
            String q = "insert into "+defaultSchema+".s_cafe_menu_units_positions (s_language, s_name, s_description, s_price, s_quantity, s_units, s_recipe) " +
                    "values (?,?,?,?,?,?,?)";
            getJdbcTemplate().update(q,
                    p.getPositionLanguage(),
                    p.getPositionName(),
                    p.getPositionDescription(),
                    p.getPositionPrice(),
                    p.getPositionQuantity(),
                    p.getPositionUnits(),
                    p.getPositionRecipeInstruction()
            );
            Integer menuPositionId = getJdbcTemplate().queryForInt("select  " +
                    "MAX(POS.S_ID) " +
                    "from  " +
                    defaultSchema+".S_CAFE_MENU_UNITS_POSITIONS POS " +
                    "left join "+defaultSchema+".S_CAFE_POSITIONS_BY_CATEGORIES PBC " +
                    "on POS.S_ID=PBC.S_POSITION_ID " +
                    "left join "+defaultSchema+".S_CAFE_MENU_UNITS MU " +
                    "on MU.S_ID=PBC.S_CATEGORY_ID " +
                    "left join "+defaultSchema+".S_CAFE_SPOT_SECTORS SECTORS " +
                    "on SECTORS.S_ID=MU.S_CAFE_SECTOR_ID " +
                    "where SECTORS.S_CAFE_SPOT_ID=? " +
                        "and s_language=? and s_name=? and s_description=? and s_price=? and s_quantity=? and s_units=? and s_recipe=?",
                    spotId,
                    p.getPositionLanguage(),
                    p.getPositionName(),
                    p.getPositionDescription(),
                    p.getPositionPrice(),
                    p.getPositionQuantity(),
                    p.getPositionUnits(),
                    p.getPositionRecipeInstruction());
            String query = "insert into s_cafe_menu_units_pos_recipes " +
                    "(s_menu_pos_id, s_ingr_id, s_quantity, s_units) " +
                    "values (?,?,?,?)";
            getJdbcTemplate().batchUpdate(query, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    preparedStatement.setInt(1, menuPositionId);
                    preparedStatement.setInt(2, p.getPositionIngredients().get(i).getIngredientId());
                    preparedStatement.setDouble(3, p.getPositionIngredients().get(i).getQuantity());
                    preparedStatement.setString(3, p.getPositionIngredients().get(i).getIngredientName());
                }

                @Override
                public int getBatchSize() {
                    return p.getPositionIngredients().size();
                }
            });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка добавления позиции в БД.");
            e.printStackTrace();
            return 0;
        }
    }

    public int removePositionById(int positionId, int spotId) {
        try {
            getJdbcTemplate().update("delete from "+defaultSchema+".s_cafe_menu_units_pos_recipes where s_menu_pos_id=?", positionId);
            getJdbcTemplate().update("delete from "+defaultSchema+".s_cafe_menu_units_positions where s_id=?", positionId);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка удаления позиции меню.");
            e.printStackTrace();
            return 0;
        }
    }

    public List<Ingredient> ingredientsShowAll(String ipAddress) {
        try {
            int spotId = getCafeIdBySpotIpAddress(ipAddress);
            List<Ingredient> result = new LinkedList<>();
            result.addAll(getJdbcTemplate().query("select * from "+defaultSchema+".s_cafe_recipes_ingredients where s_spot_id="+spotId+" order by s_id", new RowMapper<Ingredient>() {
                @Override
                public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new Ingredient(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            spotId
                    );
                }
            }));
            return result;
        } catch (Exception e) {
            System.out.println("Ошибка получения списка ингридиентов по точке");
            return null;
        }
    }

    public LinkedList<Ingredient> ingredientsShowByNamePart(String namePart, String ipAddress) {
        int spotId = getCafeIdBySpotIpAddress(ipAddress);
        try {
            LinkedList<Ingredient> result = new LinkedList<>();
            result.addAll(getJdbcTemplate().query("" +
                "select " +
                    "* " +
                    "from "+defaultSchema+".s_cafe_recipes_ingredients " +
                    "where s_spot_id="+spotId+" and s_name like ? order by s_id", new RowMapper<Ingredient>() {
                @Override
                public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new Ingredient(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            spotId
                    );
                }
            }, "%"+namePart+"%"));
            return result;
        } catch (Exception e) {
            System.out.println("Ошибка получения списка ингридиентов по точке");
            return null;
        }
    }

    public MenuPositionRecipe recipeGetById(int positionId, int spotId, HttpServletResponse response) {
        try {
            MenuPositionRecipe mpr;
            LinkedList<IngredientInRecipe> ingList = new LinkedList<>();
            ingList.addAll(getJdbcTemplate().query("SELECT * FROM "+defaultSchema+".S_CAFE_MENU_UNITS_POS_RECIPES PR " +
                    "LEFT JOIN "+defaultSchema+".S_CAFE_RECIPES_INGREDIENTS ING " +
                    "ON PR.S_INGR_ID=ING.S_ID " +
                    "WHERE PR.S_MENU_POS_ID=?", new RowMapper<IngredientInRecipe>() {
                @Override
                public IngredientInRecipe mapRow(ResultSet r, int i) throws SQLException {
                    return new IngredientInRecipe(
                            r.getInt(6),
                            r.getString(7),
                            r.getInt(8),
                            r.getString(5),
                            r.getDouble(4)
                    );
                }
            }, positionId));
            mpr = getJdbcTemplate().queryForObject(
                "select  " +
                    "MPOS.S_ID, " +
                    "LNG.S_NAME, " +
                    "MPOS.S_NAME, " +
                    "MPOS.S_PRICE, " +
                    "MPOS.S_DESCRIPTION, " +
                    "'0', " +
                    "MPOS.S_QUANTITY, " +
                    "MPOS.S_UNITS, " +
                    "MPOS.S_RECIPE, " +
                    "0, " +
                    "MPOS.S_INCLUDED " +
                "from "+defaultSchema+".s_cafe_menu_units_positions MPOS " +
                "left join "+defaultSchema+".S_UTIL_LANGUAGES LNG " +
                "on MPOS.S_LANGUAGE_ID=LNG.S_ID where MPOS.S_ID="+positionId, new RowMapper<MenuPositionRecipe>() {
                @Override
                public MenuPositionRecipe mapRow(ResultSet r, int i) throws SQLException {
                    return new MenuPositionRecipe(
                            r.getLong(1),
                            r.getString(2),
                            r.getString(3),
                            r.getDouble(4),
                            r.getString(5),
//                            null,
                            r.getDouble(7),
                            r.getString(8),
                            r.getString(9),
                            r.getInt(10),
                            r.getInt(11),
                            r.getInt(12),
                            ingList,
                            ""
                    );
                }
            }, MenuPositionRecipe.class);
            return mpr;
        } catch (Exception e) {
            System.out.println("Ошибка получения полного рецепта позиции или рецепта нет в БД");
            e.printStackTrace();
            return null;
        }
    }

    public int removeRecipeById(int positionId, int spotId) {
        try {
            getJdbcTemplate().update("delete from "+defaultSchema+".s_cafe_menu_units_pos_recipes where s_menu_pos_id="+positionId);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка удаления рецепта");
            e.printStackTrace();
            return 0;
        }
    }

    public int addIngrToRecipe(int ingrId, double ingrQuantity, String ingrUnits, int positionId, int spotId) {
        try {
            getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_menu_units_pos_recipes (s_menu_pos_id, s_ingr_id, s_quantity, s_units) values (?,?,?,?)", positionId, ingrId, ingrQuantity, ingrUnits);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка добавления ингредиента в рецепт позиции");
            e.printStackTrace();
            return 0;
        }
    }

    public int removeIngrFromRecipe(int ingrId, int positionId, int spotId) {
        try {
            getJdbcTemplate().update("delete from "+defaultSchema+".s_cafe_menu_units_pos_recipes where s_menu_pos_id="+positionId+" and s_ingr_id="+ingrId);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка удаления ингредиента из рецепта позиции");
            e.printStackTrace();
            return 0;
        }
    }

    public LinkedList<MenuCategory> getCategories(String ipAddress) {
        LinkedList<MenuCategory> result = new LinkedList<>();
        try {
            String q = "select " +
                    "MU.S_ID, MU.S_NAME, MU.S_CODE, MU.S_TYPE " +
                    "from "+defaultSchema+".S_CAFE_MENU_UNITS MU " +
                    "left join "+defaultSchema+".S_CAFE_SPOT_SECTORS SEC " +
                    "on MU.S_CAFE_SECTOR_ID=SEC.S_ID " +
                    "where SEC.S_IP=? " +
                    "order by MU.S_ID";
            result.addAll(getJdbcTemplate().query(q, new RowMapper<MenuCategory>() {
                @Override
                public MenuCategory mapRow(ResultSet r, int i) throws SQLException {
                    return new MenuCategory(
                            r.getInt(1),
                            r.getString(2),
                            r.getString(3),
                            r.getInt(4)
                    );
                }
            }, ipAddress));
            return result;
        } catch(Exception e) {
            System.out.println("Ошибка получения категорий меню объекта");
            e.printStackTrace();
            return null;
        }
    }

    public int addCategory(String catName, String catCode, String catType, String remoteAddr) {
        int spotId = getCafeIdBySpotIpAddress(remoteAddr);
        try {
            String q = "insert into "+defaultSchema+".s_cafe_menu_units (s_cafe_sector_id, s_name, s_code, s_type) values (?,?,?,?)";
            getJdbcTemplate().update(q, spotId, catName, catCode, catType);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка добавления категории");
            e.printStackTrace();
            return 0;
        }
    }

    public Integer getSpotIdBySpotIpAddress(String remoteAddr) {
        try {
            return getJdbcTemplate().queryForInt("select s_cafe_spot_id from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?", remoteAddr);
        } catch (Exception e) {
            System.out.println("Ошибка получения ID сектора по его IP-адресу: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public Integer getCafeIdBySpotIpAddress(String remoteAddr) {
        try {
            return getJdbcTemplate().queryForInt("select s_id from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?", remoteAddr);
        } catch (Exception e) {
            System.out.println("Ошибка получения ID сети по IP-адресу точки: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteCategory(int catId, String remoteAddr) {
        try {
            getJdbcTemplate().update("delete from "+defaultSchema+".s_cafe_positions_by_categories where s_category_id="+catId);
            getJdbcTemplate().update("delete from "+defaultSchema+".s_cafe_menu_units where s_id="+catId);
            return 1;
        } catch(Exception e) {
            System.out.println("Ошибка удаления категории по ID");
            e.printStackTrace();
            return 0;
        }
    }

    public int addPositionWithoutRecipe(String language, String name, MultipartFile file, int price, String description, String category, Double quantity, String units, boolean included, String remoteAddr) {
        try {
            if(file.getSize()>0) {
                LobHandler lobHandler = new DefaultLobHandler();
                String q = "insert into " + defaultSchema + ".s_cafe_menu_units_positions (s_language_id, s_name, s_description, s_price, s_quantity, s_units, s_recipe, s_included, s_picture) " +
                        "values (?,?,?,?,?,?,?,?,?)";
                int inc = 1;
                if (!included)
                    inc = 0;
                getJdbcTemplate().update(q, new Object[]{
                                Integer.parseInt(language),
                                name,
                                description,
                                price,
                                quantity,
                                units,
                                "",
                                inc,
                                new SqlLobValue(file.getInputStream(), (int) file.getSize(), lobHandler)
                        },
                        new int[]{
                                Types.INTEGER,
                                Types.VARCHAR,
                                Types.VARCHAR,
                                Types.INTEGER,
                                Types.DOUBLE,
                                Types.VARCHAR,
                                Types.VARCHAR,
                                Types.INTEGER,
                                Types.BLOB

                        }
                );
                int positionId = getJdbcTemplate().queryForInt("select max(s_id) from " + defaultSchema + ".s_cafe_menu_units_positions where " +
                                "s_language_id=? and s_name=? and s_description=? and s_price=? and s_quantity=? and s_units=? and s_included=?",
                        Integer.parseInt(language),
                        name,
                        description,
                        price,
                        quantity,
                        units,
                        inc
                );
                getJdbcTemplate().update("insert into " + defaultSchema + ".s_cafe_positions_by_categories (s_position_id, s_category_id) values (?,?)", new Object[]{
                        positionId,
                        Integer.parseInt(category)
                });
            } else {
                String q = "insert into " + defaultSchema + ".s_cafe_menu_units_positions (s_language_id, s_name, s_description, s_price, s_quantity, s_units, s_recipe, s_included, s_picture) " +
                        "values (?,?,?,?,?,?,?,?,null)";
                int inc = 1;
                if (!included)
                    inc = 0;
                getJdbcTemplate().update(q, new Object[]{
                                Integer.parseInt(language),
                                name,
                                description,
                                price,
                                quantity,
                                units,
                                "",
                                inc
                },
                        new int[]{
                                Types.INTEGER,
                                Types.VARCHAR,
                                Types.VARCHAR,
                                Types.INTEGER,
                                Types.DOUBLE,
                                Types.VARCHAR,
                                Types.VARCHAR,
                                Types.INTEGER
                        }
                );
                int positionId = getJdbcTemplate().queryForInt("select max(s_id) from " + defaultSchema + ".s_cafe_menu_units_positions where " +
                                "s_language_id=? and s_name=? and s_description=? and s_price=? and s_quantity=? and s_units=? and s_included=?",
                        Integer.parseInt(language),
                        name,
                        description,
                        price,
                        quantity,
                        units,
                        inc
                );
                getJdbcTemplate().update("insert into " + defaultSchema + ".s_cafe_positions_by_categories (s_position_id, s_category_id) values (?,?)", new Object[]{
                        positionId,
                        Integer.parseInt(category)
                });
            }
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка добавления позиции в БД.");
            e.printStackTrace();
            return 0;
        }
    }
}






















