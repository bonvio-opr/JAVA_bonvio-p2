package com.bonvio.project2.dao.common.groups.implementation;

import com.bonvio.project2.classes.common.groups.Group;
import com.bonvio.project2.classes.common.groups.Point;
import com.bonvio.project2.dao.BaseDao;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 19.12.2014.
 */
public class PointManagmentDaoImpl extends BaseDao {
    public PointManagmentDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public int createPoint(Point point, int ownerId) {
        try {
            getJdbcTemplate().update("insert into "+defaultSchema+".s_g_point (s_id, s_name, s_group_id, s_description) values (?,?,?,?)",
                    point.getId(),
                    point.getName(),
                    point.getGroupId(),
                    point.getDescription()
                    );
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка создания точки: ошибка записи в БД");
            e.printStackTrace();
            return 0;
        }
    }


    public int deletePoint(int pointId, int ownerId) {
        try {
            int update = getJdbcTemplate().update("delete from " + defaultSchema + ".s_g_point where s_id = ? ",
                    pointId
            );
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка удаления точки: ошибка записи в БД");
            e.printStackTrace();
            return 0;
        }
    }

    public Point getPointById (int pointId, int ownerId) {
        Point point = null;
        try {
            point = getJdbcTemplate().queryForObject("select * from " + defaultSchema + ".s_g_point where s_id = ? ",
                    new RowMapper<Point>() {
                        @Override
                        public Point mapRow(ResultSet rs, int rowNum) throws SQLException {
                            return new Point (
                                    rs.getInt("s_id"),
                                    rs.getString("s_name"),
                                    rs.getInt("s_group_id"),
                                    rs.getString("s_description")
                            );
                        }
                    },
                    Point.class,
                    pointId
            );
            return point;
        } catch (Exception e) {
            System.out.println("Ошибка получения точки: ошибка записи в БД");
            e.printStackTrace();
            return null;
        }
    }

    public List<Point> getPointsByGroupId (int groupId, int ownerId) {
        List<Point> points = new ArrayList<>();
        try {
            points.addAll(getJdbcTemplate().query("select * from " + defaultSchema + ".s_g_point where s_group_id = ? ",
                    new RowMapper<Point>() {
                        @Override
                        public Point mapRow(ResultSet rs, int rowNum) throws SQLException {
                            return new Point (
                                    rs.getInt("s_id"),
                                    rs.getString("s_name"),
                                    rs.getInt("s_group_id"),
                                    rs.getString("s_description")
                            );
                        }
                    },
                    groupId
            ));
            return points;
        } catch (Exception e) {
            System.out.println("Ошибка получения точки по Ид: ошибка записи в БД");
            e.printStackTrace();
            return null;
        }
    }



}
