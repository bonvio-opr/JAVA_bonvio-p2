package com.bonvio.project2.dao.settings.profile.implementation;

import com.bonvio.project2.classes.settings.profile.FullUserProfile;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.settings.profile.SettingsProfileManagementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 07.10.2014.
 */
public class SettingsProfileManagementDaoImpl extends BaseDao implements SettingsProfileManagementDao {

    @Autowired
    public SettingsProfileManagementDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public FullUserProfile getMyFullUserProfile(String userId, String userPhone) {
        LinkedList<FullUserProfile> profile = new LinkedList<FullUserProfile>();
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
                " from " + defaultSchema + ".s_users where s_id = " + Integer.parseInt(userId) + " and s_phonenumber = ? and s_enabled = 1";
        try {
            profile.addAll(getJdbcTemplate().query(q, new RowMapper<FullUserProfile>() {
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
                            r.getString("S_CITY"),
                            r.getString("S_COUNTRY")
                    );

                }
            }, userPhone));
            return profile.get(0);
        } catch (EmptyResultDataAccessException ep) {
            ep.printStackTrace();
            return null;
        }
    }

    public int refreshMyFullUserProfile(String userId, String userPhone, FullUserProfile userProfile) {
        String query =
                "UPDATE S_USERS SET " +
                        "S_EMAIL = ?, " +
                        "S_FIRST_NAME = ?, " +
                        "S_SECOND_NAME = ?, " +
                        "S_PATRONYMIC = ?, " +
                        "S_DOCTYPE = ?, " +
                        "S_DOCCODE = ?, " +
                        "S_CITY = ?, " +
                        "S_COUNTRY = ? " +
                        "WHERE S_ID = ?";
        try {
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            userProfile.getProfileEmail(),
                            userProfile.getProfileName(),
                            userProfile.getProfileSurname(),
                            userProfile.getProfilePatronymic(),
                            userProfile.getProfileDocType(),
                            userProfile.getProfileDocCode(),
                            userProfile.getProfileCity(),
                            userProfile.getProfileCountry(),
                            userId}
            );
            return 1;
        } catch (Exception ept) {
            ept.printStackTrace();
            return 0;
        }
    }

    public int refreshUserPassAndPhone(String userId, FullUserProfile userProfile) {
        String query =
                "UPDATE S_USERS SET " +
                        "S_PHONENUMBER = ?, " +
                        "S_PASSWORD = ? " +
                        "WHERE S_ID = ?";
        try {
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            userProfile.getProfilePhoneNumber(),
                            userProfile.getProfilePassword(),
                            userId}
            );
            return 1;
        } catch (Exception ept) {
            ept.printStackTrace();
            return 0;
        }
    }

    public int addImage(String userId, MultipartFile file) {
        LobHandler lobHandler = new DefaultLobHandler();
        String query =
                "UPDATE S_USERS SET " +
                        "S_IMAGE = ? " +
                        "WHERE S_ID = ?";
        try {
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            new SqlLobValue(file.getInputStream(), (int) file.getSize(), lobHandler),
                            userId}
            );
            return 1;
        } catch (Exception ept) {
            ept.printStackTrace();
            return 0;
        }
    }

    public List<FullUserProfile> getUsers() {
        List<FullUserProfile> users = new ArrayList<>();

        try {
            users.addAll(getJdbcTemplate().query(
                    "select " +
                            "s_id, " +
                            "s_email, " +
                            "s_first_name, " +
                            "s_second_name, " +
                            "s_patronymic, " +
                            "s_phonenumber, " +
                            "s_doctype, " +
                            "s_doccode, " +
                            "s_city, " +
                            "s_country " +
                            " from " + defaultSchema + ".s_users ",
                    new RowMapper<FullUserProfile>() {
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
                                    r.getString("S_CITY"),
                                    r.getString("S_COUNTRY")
                            );

                        }
                    }));
            return users;
        } catch (EmptyResultDataAccessException ep) {
            ep.printStackTrace();
            return null;
        }


    }


}