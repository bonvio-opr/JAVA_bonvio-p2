package com.bonvio.project2.dao.settings.profile.implementation;

import com.bonvio.project2.classes.settings.profile.FullUserProfile;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.settings.profile.SettingsProfileManagementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Arti on 07.10.2014.
 */
public class SettingsProfileManagementDaoImpl extends BaseDao implements SettingsProfileManagementDao {

    @Autowired
    public SettingsProfileManagementDaoImpl(DataSource dataSource) {
        super(dataSource);
    }


    public FullUserProfile getMyFullUserProfile(String userId, String userPhone) {
        LinkedList<FullUserProfile> profile = new LinkedList<>();
        String q = "select " +
                "s_id, " +
                "s_email, " +
                "s_first_name, " +
                "s_second_name, " +
                "s_patronymic," +
                "s_phonenumber, " +
                "s_doctype, " +
                "s_doccode, " +
                "s_city, " +
                "s_country " +
                " from "+defaultSchema+".s_users where s_id = "+Integer.parseInt(userId)+" and s_phonenumber = ? and s_enabled = 1";
        try {
            profile.addAll( getJdbcTemplate().query(q, new RowMapper<FullUserProfile>() {
                @Override
                public FullUserProfile mapRow(ResultSet r, int i) throws SQLException {
                    return new FullUserProfile(
                            r.getInt("S_ID"),
                            r.getString("S_EMAIL"),
                            r.getString("S_FIRST_NAME"),
                            r.getString("S_SECOND_NAME"),
                            r.getString("S_PATRONYMIC"),
                            "",
                            r.getString("S_PHONENUMBER"),
                            r.getInt("S_DOCTYPE"),
                            r.getString("S_DOCCODE"),
                            r.getString("S_COUNTRY"),
                            r.getString("S_CITY")
                    );
                }
            }, userPhone));
            return profile.get(0);
        } catch(EmptyResultDataAccessException ep) {
            ep.printStackTrace();
            return null;
        }
    }

    public int refreshMyFullUserProfile(String userId, String userPhone, FullUserProfile f) {
        String q = "update "+defaultSchema+".s_users set(" +
                "s_email, " +
                "s_first_name, " +
                "s_second_name, " +
                "s_patronymic," +
                "s_phonenumber, " +
                "s_doctype, " +
                "s_doccode, " +
                "s_city, " +
                "s_country) " +
                "values (?,?,?,?,?,?,?,?,?) " +
                "where s_id = "+Integer.parseInt(userId)+" and s_phonenumber = ?";
        try {
            getJdbcTemplate().update(
                    q,
                    f.getProfileEmail(),
                    f.getProfileName(),
                    f.getProfileSurname(),
                    f.getProfilePatronymic(),
                    f.getProfilePhoneNumber(),
                    f.getProfileDocType(),
                    f.getProfileDocCode(),
                    f.getProfileCity(),
                    f.getProfileCountry(),
                    userPhone
            );
            return 1;
        } catch(Exception ept) {
            ept.printStackTrace();
            return 0;
        }
    }
}