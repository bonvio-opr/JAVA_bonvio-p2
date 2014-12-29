package com.bonvio.project2.dao.common.groups.implementation;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import com.bonvio.project2.classes.common.groups.Member;
import com.bonvio.project2.classes.settings.profile.FullUserProfile;
import com.bonvio.project2.dao.BaseDao;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivan on 24.12.2014.
 */
public class MemberManagmentDaoImpl extends BaseDao {
    public MemberManagmentDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public List<Member> getUserInvitations(String idUserString) {
        List<Member> members = new ArrayList<>();
        try {
            int idUser = Integer.parseInt(idUserString);
            members.addAll(getJdbcTemplate().query(
                    "SELECT " +
                            "s_g_members.S_ID, " +
                            "s_g_members.S_USER_ID, " +
                            "s_g_members.S_GROUP_ID, " +
                            "s_g_members.S_USER_RIGHTS_ID, " +
                            "s_g_members.S_SENDER_ID, " +
                            "s_g_members.S_SEND_DATE, " +
                            "s_g_members.S_ACCEPTED_DATE, " +
                            "s_g_members.S_ACCEPTED, " +
                            "s_users.S_FIRST_NAME, " +
                            "s_users.S_SECOND_NAME, " +
                            "s_users.S_PATRONYMIC, " +
                            "s_groups.s_name " +
                            "FROM " +
                            defaultSchema + ".s_g_members, " +
                            defaultSchema + ".s_users, " +
                            defaultSchema + ".s_groups " +
                            "WHERE s_users.s_id = s_g_members.S_USER_ID " +
                            "AND s_g_members.s_accepted = 0 " +
                            "AND s_g_members.S_GROUP_ID = s_groups.s_id " +
                            "AND s_users.s_id = ?",
                    new RowMapper<Member>() {
                        @Override
                        public Member mapRow(ResultSet r, int i) throws SQLException {
                            return new Member(
                                    r.getInt("S_ID"),
                                    r.getInt("S_USER_ID"),
                                    r.getInt("S_GROUP_ID"),
                                    r.getInt("S_USER_RIGHTS_ID"),
                                    r.getInt("S_SENDER_ID"),
                                    r.getDate("S_SEND_DATE"),
                                    r.getDate("S_ACCEPTED_DATE"),
                                    r.getInt("S_ACCEPTED"),
                                    r.getString("S_FIRST_NAME"),
                                    r.getString("S_SECOND_NAME"),
                                    r.getString("S_PATRONYMIC"),
                                    r.getString("S_NAME")
                            );
                        }
                    }, idUser));
            return members;
        } catch (Exception e) {
            System.out.println("Ошибка getUserInvitations: ошибка запроса к БД");
            e.printStackTrace();
            return null;
        }
    }


    public List<Member> getMembers(String idGroupString, String idUserString) {
        List<Member> members = new ArrayList<>();
        try {
            int idGroup = Integer.parseInt(idGroupString);
            int idUser = Integer.parseInt(idUserString);
            members.addAll(getJdbcTemplate().query(
                    "SELECT " +
                            "s_g_members.S_ID, " +
                            "s_g_members.S_USER_ID, " +
                            "s_g_members.S_GROUP_ID, " +
                            "s_g_members.S_USER_RIGHTS_ID, " +
                            "s_g_members.S_SENDER_ID, " +
                            "s_g_members.S_SEND_DATE, " +
                            "s_g_members.S_ACCEPTED_DATE, " +
                            "s_g_members.S_ACCEPTED, " +
                            "s_users.S_FIRST_NAME, " +
                            "s_users.S_SECOND_NAME, " +
                            "s_users.S_PATRONYMIC, " +
                            "s_groups.s_name " +
                            "FROM " +
                            defaultSchema + ".s_g_members, " +
                            defaultSchema + ".s_users, " +
                            defaultSchema + ".s_groups " +
                            "WHERE s_g_members.S_GROUP_ID = s_groups.S_ID " +
                            "AND s_users.s_id = s_g_members.S_USER_ID " +
                            "AND s_g_members.s_accepted = 1 " +
                            /*"AND s_g_members.S_USER_ID = ? " +*/
                            "AND s_groups.S_ID = ? "
                            /*+
                            "AND (s_g_members.S_USER_RIGHTS_ID = 4 OR  s_g_members.S_USER_RIGHTS_ID = 3)"*/,
                    new RowMapper<Member>() {
                        @Override
                        public Member mapRow(ResultSet r, int i) throws SQLException {
                            return new Member(
                                    r.getInt("S_ID"),
                                    r.getInt("S_USER_ID"),
                                    r.getInt("S_GROUP_ID"),
                                    r.getInt("S_USER_RIGHTS_ID"),
                                    r.getInt("S_SENDER_ID"),
                                    r.getDate("S_SEND_DATE"),
                                    r.getDate("S_ACCEPTED_DATE"),
                                    r.getInt("S_ACCEPTED"),
                                    r.getString("S_FIRST_NAME"),
                                    r.getString("S_SECOND_NAME"),
                                    r.getString("S_PATRONYMIC"),
                                    r.getString("S_NAME")
                            );
                        }
                    },/* idUser,*/ idGroup));
            return members;
        } catch (Exception e) {
            System.out.println("Ошибка getMembers: ошибка запроса к БД");
            e.printStackTrace();
            return null;
        }
    }

    public List<Member> getGroupInvitations(String idGroupString, String idUserString) {
        List<Member> members = new ArrayList<>();
        try {
            int idGroup = Integer.parseInt(idGroupString);
            int idUser = Integer.parseInt(idUserString);
            members.addAll(getJdbcTemplate().query(
                    "SELECT " +
                            "s_g_members.S_ID, " +
                            "s_g_members.S_USER_ID, " +
                            "s_g_members.S_GROUP_ID, " +
                            "s_g_members.S_USER_RIGHTS_ID, " +
                            "s_g_members.S_SENDER_ID, " +
                            "s_g_members.S_SEND_DATE, " +
                            "s_g_members.S_ACCEPTED_DATE, " +
                            "s_g_members.S_ACCEPTED, " +
                            "s_users.S_FIRST_NAME, " +
                            "s_users.S_SECOND_NAME, " +
                            "s_users.S_PATRONYMIC, " +
                            "s_groups.s_name " +
                            "FROM " +
                            defaultSchema + ".s_g_members, " +
                            defaultSchema + ".s_users, " +
                            defaultSchema + ".s_groups " +
                            "WHERE s_g_members.S_GROUP_ID = s_groups.S_ID " +
                            "AND s_users.s_id = s_g_members.S_USER_ID " +
                            "AND s_g_members.s_accepted = 0 " +
                            /*"AND s_g_members.S_USER_ID = ? " +*/
                            "AND s_groups.S_ID = ? ",
                    new RowMapper<Member>() {
                        @Override
                        public Member mapRow(ResultSet r, int i) throws SQLException {
                            return new Member(
                                    r.getInt("S_ID"),
                                    r.getInt("S_USER_ID"),
                                    r.getInt("S_GROUP_ID"),
                                    r.getInt("S_USER_RIGHTS_ID"),
                                    r.getInt("S_SENDER_ID"),
                                    r.getDate("S_SEND_DATE"),
                                    r.getDate("S_ACCEPTED_DATE"),
                                    r.getInt("S_ACCEPTED"),
                                    r.getString("S_FIRST_NAME"),
                                    r.getString("S_SECOND_NAME"),
                                    r.getString("S_PATRONYMIC"),
                                    r.getString("S_NAME")
                            );
                        }
                    }, /*idUser,*/ idGroup));
            return members;
        } catch (Exception e) {
            System.out.println("Ошибка getGroupInvitations: ошибка запроса к БД");
            e.printStackTrace();
            return null;
        }
    }


    public int inviteUser(String idGroupString, String idUserString, FullUserProfile user) {

        //TODO добавить проверку может ли юзер добавлять в группу
        try {
            int idGroup = Integer.parseInt(idGroupString);
            int idUser = Integer.parseInt(idUserString);
            String query = "insert into " + defaultSchema + ".s_g_members (S_USER_ID, S_GROUP_ID, S_USER_RIGHTS_ID, S_SENDER_ID, S_SEND_DATE, S_ACCEPTED_DATE, S_ACCEPTED) values (?,?,?,?,?,?,?)";
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            user.getProfileId(),
                            idGroup,
                            0,
                            idUser,
                            new Date(),
                            null,
                            0
                    }
            );
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка приглашения участника: ошибка записи в БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteFromGroup(String idGroupString, String idUserString, Member member) {
        //TODO добавить проверку может ли админ группы удалить участника
        try {
            int idGroup = Integer.parseInt(idGroupString);
            int idUser = Integer.parseInt(idUserString);
            getJdbcTemplate().update(
                    "delete from " + defaultSchema + ".s_g_members where s_id = ? and s_group_id = ?",
                    new Object[]{
                            member.getId(),
                            idGroup
                    });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка удаления участника из группы: ошибка запроса к БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int joinToGroup(String idGroupString, String idUserString) {
        try {
            int idGroup = Integer.parseInt(idGroupString);
            int idUser = Integer.parseInt(idUserString);
            String query = "insert into " + defaultSchema + ".s_g_members (S_USER_ID, S_GROUP_ID, S_USER_RIGHTS_ID, S_SENDER_ID, S_SEND_DATE, S_ACCEPTED_DATE, S_ACCEPTED) values (?,?,?,?,?,?,?)";
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            idUser,
                            idGroup,
                            0,
                            idUser,
                            new Date(),
                            null,
                            0
                    }
            );
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка приглашения участника: ошибка записи в БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int leaveGroup(String idGroupString, String idUserString) {
        try {
            int idGroup = Integer.parseInt(idGroupString);
            int idUser = Integer.parseInt(idUserString);
            getJdbcTemplate().update(
                    "update table " + defaultSchema + ".s_g_members set S_ACCEPTED=0 where s_group_id=? and s_user_id=?",
                    new Object[]{
                            idGroup,
                            idUser
                    });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка ухода участника из группы: ошибка запроса к БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int acceptUserToGroup(String idGroupString, Member member) {
        //TODO проверка может ли принимать пользователя
        try {
            int idGroup = Integer.parseInt(idGroupString);
            getJdbcTemplate().update(
                    "update " + defaultSchema + ".s_g_members set s_accepted=1 where s_group_id=? and s_id=? " /*+ "and s_user_id = s_sender_id"*/,
                    new Object[]{
                            idGroup,
                            member.getId()
                    });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка принятия участником приглашения в группу: ошибка запроса к БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int acceptGroupInvitation(String idGroupString, String idUserString) {
        try {
            int idGroup = Integer.parseInt(idGroupString);
            int idUser = Integer.parseInt(idUserString);
            getJdbcTemplate().update(
                    "update " + defaultSchema + ".s_g_members set s_accepted=1 where s_group_id=? and s_user_id=? s_user_id != s_sender_id",
                    new Object[]{
                            idGroup,
                            idUser
                    });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка принятия участника в группу: ошибка запроса к БД");
            e.printStackTrace();
            return 0;
        }
    }


}
