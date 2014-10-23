package com.bonvio.project2.dao.cafe.barman.implementation;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.barman.CafeBarmanMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 30.07.2014.
 */
public class CafeBarmanMenuDaoImpl extends BaseDao implements CafeBarmanMenuDao {

    @Autowired
    public CafeBarmanMenuDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String getCategoryNameByPositionMenuIdAndSpotId(int menuPositionId, int spotId) {
        String q =
            "select " +
                "S_NAME " +
            "from S_CAFE_POSITIONS_BY_CATEGORIES PBC " +
            "left join S_CAFE_MENU_UNITS MU " +
            "on PBC.S_CATEGORY_ID=MU.S_ID " +
            "where " +
                "PBC.S_POSITION_ID=? and S_CAFE_SECTOR_ID=?";
        return getJdbcTemplate().queryForObject(q, String.class, menuPositionId, spotId);
    }

    @Override
    public List<MenuPosition> getMenuPositionsByCategoryId(int categoryId) {
        String q =
            "select MUP.S_ID, LANG.S_NAME, MUP.S_NAME, MUP.S_PRICE, MUP.S_DESCRIPTION, MUP.S_PICTURE, MUP.S_QUANTITY, MUP.S_UNITS, MUP.S_RECIPE, 0, MUP.S_INCLUDED, MU.S_TYPE " +
            "from S_CAFE_MENU_UNITS MU  " +
            "left join S_CAFE_POSITIONS_BY_CATEGORIES PBC " +
            "on MU.S_ID=PBC.S_CATEGORY_ID " +
            "left join S_CAFE_MENU_UNITS_POSITIONS MUP " +
            "on PBC.S_POSITION_ID=MUP.S_ID " +
            "left join S_UTIL_LANGUAGES LANG " +
            "on MUP.S_LANGUAGE_ID=LANG.S_ID " +
            "where MUP.S_INCLUDED>0 and PBC.S_CATEGORY_ID=? order by MUP.S_ID";
        List<MenuPosition> mpList = new LinkedList<>();
        mpList.addAll(getJdbcTemplate().query(q, new RowMapper<MenuPosition>() {
            @Override
            public MenuPosition mapRow(ResultSet r, int i) throws SQLException {
                return new MenuPosition(
                        r.getLong(1),
                        r.getString(2),
                        r.getString(3),
                        r.getDouble(4),
                        r.getString(5),
                        r.getBlob(6),
                        r.getDouble(7),
                        r.getString(8),
                        r.getString(9),
                        r.getInt(10),
                        r.getInt(11),
                        r.getInt(12)
                );
            }
        }, categoryId));
        return mpList;
    }

    @Override
    public MenuPosition getPositionFullInfoByPositionId(int positionId) {
        String q =
            "select MUP.S_ID, L.S_NAME, MUP.S_PRICE, MUP.S_DESCRIPTION, MUP.S_PICTURE, MUP.S_QUANTITY, MUP.S_UNITS, MUP.S_RECIPE, 0, MUP.S_INCLUDED from s_cafe_menu_units_positions MUP " +
            "left join S_UTIL_LANGUAGES L " +
            "on MUP.S_LANGUAGE_ID=L.S_ID " +
                    "left join "+defaultSchema+".s_cafe_positions_by_categories PBC " +
                    "on PBC.S_POSITION_ID=MUP.S_ID " +
                    "left join "+defaultSchema+".s_cafe_menu_units MU " +
                    "on MU.S_ID=PBC.S_CATEGORY_ID " +
            "where MUP.S_ID=?";
        return getJdbcTemplate().queryForObject(q, new RowMapper<MenuPosition>() {
            @Override
            public MenuPosition mapRow(ResultSet r, int i) throws SQLException {
                return new MenuPosition(
                        r.getLong(1),
                        r.getString(2),
                        r.getString(3),
                        r.getDouble(4),
                        r.getString(5),
                        r.getBlob(6),
                        r.getDouble(7),
                        r.getString(8),
                        r.getString(9),
                        r.getInt(10),
                        r.getInt(11),
                        r.getInt(12)
                );
            }
        }, MenuPosition.class, positionId);
    }
}
