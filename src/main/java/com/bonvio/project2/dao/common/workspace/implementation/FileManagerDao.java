package com.bonvio.project2.dao.common.workspace.implementation;

import com.bonvio.project2.dao.BaseDao;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ivan on 28.11.2014.
 */
public class FileManagerDao extends BaseDao {

    public FileManagerDao(DataSource dataSource) {
        super(dataSource);
    }



    public void insertUser(String number) {
        ArrayList<String> pList = new ArrayList<String>();
        pList.addAll(getJdbcTemplate().query("select s_pwd from " + defaultSchema + ".s_users_unconfirmed where s_user_phone=?", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(1);
            }
        }, number));
        getJdbcTemplate().update("insert into " + defaultSchema + ".s_users (s_phonenumber, s_password) values (?,?)", number, pList.get(0));
        getJdbcTemplate().update("delete from " + defaultSchema + ".s_users_unconfirmed where s_user_phone=?", number);
        Integer s_user_id = getJdbcTemplate().queryForInt("select s_id from " + defaultSchema + ".s_users where s_phonenumber=?", number);
        getJdbcTemplate().update("insert into " + defaultSchema + ".s_u_ws (s_user_id, s_ws_name) values (?,'Моя навигация')", s_user_id);
    }






}
