package com.bonvio.project2.dao.common.groups.implementation;

import com.bonvio.project2.classes.common.groups.Group;
import com.bonvio.project2.classes.common.groups.GroupApplicationTemplateDBExtractor;
import com.bonvio.project2.classes.common.groups.GroupApplicationsTemplate;
import com.bonvio.project2.classes.common.groups.TemplateApp;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.common.groups.GroupsManagementDao;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.awt.geom.Point2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Arti on 06.08.2014.
 */
public class GroupsManagementDaoImpl extends BaseDao implements GroupsManagementDao {
    public GroupsManagementDaoImpl(DataSource dataSource) {
        super(dataSource);
    }


    public int groupManagementCreateGroup(Group gr, int ownerId) {
        try {
            String q = "insert into "+defaultSchema+".s_groups (s_name, s_name_short, s_owner_id, s_group_info, s_avatar_path) values (?,?,?,?,?)";
            getJdbcTemplate().update(q, gr.getGroupName(), gr.getGroupShortName(), ownerId, gr.getGroupInfo(), gr.getGroupPicturePath());
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка создания группы: ошибка записи в БД");
            e.printStackTrace();
            return 0;
        }
    }

    public List<Group> groupManagementSearchByName(String namePart) {
        List<Group> gList = new LinkedList<>();
        try {
            String q = "select * from "+defaultSchema+".s_groups where s_name like '?' order by S_NAME";
            gList.addAll(getJdbcTemplate().query(q, new RowMapper<Group>() {
                @Override
                public Group mapRow(ResultSet r, int i) throws SQLException {
                    return new Group(
                            r.getInt(1),
                            r.getString(2),
                            r.getString(3),
                            r.getString(4),
                            r.getString(5)
                    );
                }
            }, namePart));
            return gList;
        } catch (Exception e) {
            System.out.println("Ошибка поиска групп: ошибка запроса к БД");
            e.printStackTrace();
            return null;
        }
    }


    public Group groupManagementWatchGroup(int groupId) {
        Group gList = new Group();
        try {
            String q = "select * from "+defaultSchema+".s_groups where s_id=? order by S_NAME";
            return getJdbcTemplate().queryForObject(q, new RowMapper<Group>() {
                @Override
                public Group mapRow(ResultSet r, int i) throws SQLException {
                    return new Group(
                            r.getInt(1),
                            r.getString(2),
                            r.getString(3),
                            r.getString(4),
                            r.getString(5)
                    );
                }
            }, Group.class, groupId);
        } catch (Exception e) {
            System.out.println("Ошибка получения полной информации о группе: ошибка запроса к БД");
            e.printStackTrace();
            return null;
        }
    }

//    public int groupManagementInviteUser(int invitedUserId, int groupId, LinkedList<Integer> appNumbersList) {
    public int groupManagementInviteUser(int inviterUserId, int invitedUserId, int groupId) {
        try {
            String q = "insert into "+defaultSchema+".s_g_invites (s_group_id, s_sender_id, s_receiver_id, s_date_sent, s_date_accepted, s_date_rejected) values (?,?,?,SYSDATE,?,?)";
            getJdbcTemplate().update(q, groupId, inviterUserId, invitedUserId, null, null);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка отправки приглашения: ошибка запроса к БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int groupManagementAcceptInvitation(int invitedUserId, int groupId) {
        try {
            String q = "update table "+defaultSchema+".s_g_invites set s_date_accepted=SYSDATE where s_group_id=? and s_receiver_id=?";
            getJdbcTemplate().update(q, groupId, invitedUserId);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка принятия приглашения: ошибка запроса к БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int groupManagementRejectInvitation(int invitedUserId, int groupId) {
        try {
            String q = "update table "+defaultSchema+".s_g_invites set s_date_rejected=SYSDATE where s_group_id=? and s_receiver_id=?";
            getJdbcTemplate().update(q, groupId, invitedUserId);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка отклонения приглашения: ошибка запроса к БД");
            e.printStackTrace();
            return 0;
        }
    }

    public int groupManagementSpotAddExisting(int spotId, int groupId) {
        try {
            String q = "insert into "+defaultSchema+".s_g_spots (S_GROUP_ID, S_SPOT_ID) values(?,?)";
            getJdbcTemplate().update(q, groupId, spotId);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int groupManagementSpotCreateThenAdd(Point2D.Double spotLatLon, String spotAddress, int groupId, String spotName, String country, String city) {
        try {
            getJdbcTemplate().update("insert into "+defaultSchema+".s_cafe_spots (S_NAME, S_COORDS, S_ADDRESS, S_COUNTRY, S_CITY) values (?,?,?,?,?)", spotName, spotLatLon, spotAddress, country, city);
            Integer spotNumInTable = getJdbcTemplate().queryForInt("select s_id from "+defaultSchema+".s_cafe_spots where s_name=? and s_address=?", spotName, spotAddress);
            getJdbcTemplate().update("insert into "+defaultSchema+".s_g_spots (s_group_id, s_spot_id) values (?,?)", groupId, spotNumInTable);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка создания точки: ошибка в синтаксисе Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int groupManagementLeaveGroup(int userId, int groupId) {
        try {
            groupManagementKickFromGroup(userId, groupId, "ПСЖ");
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка выхода из группы: ошибка в синтаксисе Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int groupManagementKickFromGroup(int userId, int groupId, String reason) {
        try {
            groupManagementKickFromGroup(userId, groupId, "ПСЖ");
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка выхода из группы: ошибка в синтаксисе Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int groupManagementUpdateGroupInfo(Group g) {
        try {
            String q = "update table "+defaultSchema+".s_groups (S_NAME, S_NAME_SHORT, S_GROUP_INFO, S_AVATAR_PATH) VALUES (?,?,?,?) where s_id=?";
            getJdbcTemplate().update(q,
                    g.getGroupName(),
                    g.getGroupShortName(),
                    g.getGroupInfo(),
                    g.getGroupPicturePath(),
                    g.getGroupId()
            );
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public GroupApplicationsTemplate getTemplateById(int templateId, int groupId) {
        try {
            List<TemplateApp> tappList = new LinkedList<>();
            List<GroupApplicationTemplateDBExtractor> tList = new LinkedList<>();
            GroupApplicationsTemplate result = new GroupApplicationsTemplate();
            String q = "select " +
                    "T.S_ID, T.S_NAME, WSA.S_ID, WSA.S_NAME " +
                    "from "+defaultSchema+".S_G_WS_TEMPLATES T " +
                    "left join "+defaultSchema+".S_G_WS_TEMPLATE_APPS TA " +
                    "on T.S_ID=TA.S_TEMPLATE_ID " +
                    "left join "+defaultSchema+".S_WS_APPS WSA " +
                    "on WSA.S_ID=TA.S_APP_ID " +
                    "where T.S_ID=? and T.S_GROUP_ID=?";
            tList.addAll(getJdbcTemplate().query(q, new RowMapper<GroupApplicationTemplateDBExtractor>() {
                @Override
                public GroupApplicationTemplateDBExtractor mapRow(ResultSet r, int i) throws SQLException {
                    return new GroupApplicationTemplateDBExtractor(
                            r.getInt(1),
                            r.getString(2),
                            r.getInt(3),
                            r.getString(4)
                    );
                }
            }, templateId, groupId));
            tappList.addAll(tList.stream().map(e -> new TemplateApp(e.getaId(), e.getaName())).collect(Collectors.toList()));

            return new GroupApplicationsTemplate(tList.get(0).gettName(), tList.get(0).gettId(), tappList);
        } catch (Exception e) {
            return null;
        }
    }

    public List<GroupApplicationsTemplate> getTemplates(int groupId) {
        try {
            List<GroupApplicationsTemplate> result = new LinkedList<>();
            List<TemplateApp> tappList = new LinkedList<>();
            List<GroupApplicationTemplateDBExtractor> tList = new LinkedList<>();
            String q = "select " +
                    "T.S_ID, T.S_NAME, WSA.S_ID, WSA.S_NAME " +
                    "from "+defaultSchema+".S_G_WS_TEMPLATES T " +
                    "left join "+defaultSchema+".S_G_WS_TEMPLATE_APPS TA " +
                    "on T.S_ID=TA.S_TEMPLATE_ID " +
                    "left join "+defaultSchema+".S_WS_APPS WSA " +
                    "on WSA.S_ID=TA.S_APP_ID " +
                    "where T.S_GROUP_ID=? and WSA.S_NAME is not null " +
                    "group by T.S_ID, T.S_NAME, WSA.S_ID, WSA.S_NAME " +
                    "order by T.S_ID";
            tList.addAll(getJdbcTemplate().query(q, new RowMapper<GroupApplicationTemplateDBExtractor>() {
                @Override
                public GroupApplicationTemplateDBExtractor mapRow(ResultSet r, int i) throws SQLException {
                    return new GroupApplicationTemplateDBExtractor(
                            r.getInt(1),
                            r.getString(2),
                            r.getInt(3),
                            r.getString(4)
                    );
                }
            }, groupId));
            if(tList.size()>0) {
                int currTId = tList.get(0).gettId();
                String currTName = tList.get(0).gettName();

                for (int i = 0; i < tList.size(); i++) {
                    if (tList.get(i).gettId() == currTId) {
                        tappList.add(new TemplateApp(tList.get(i).getaId(), tList.get(i).getaName()));
                    } else {
                        result.add(new GroupApplicationsTemplate(currTName, currTId, tappList));
                        tappList.clear();
                        currTId = tList.get(i).gettId();
                        currTName = tList.get(i).gettName();
                    }
                }
                result.add(new GroupApplicationsTemplate(currTName, currTId, tappList));
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public int createTemplate(int groupId, String templateName, final List<TemplateApp> templateApps) {
        try {
            getJdbcTemplate().update("insert into "+defaultSchema+".s_g_ws_templates (s_group_id, s_name) values (?,?)");
            Integer k = getJdbcTemplate().queryForInt("select s_id from "+defaultSchema+".s_g_ws_templates where s_group_id=? and s_name=? and rownum<2 order by s_id desc ", groupId, templateName);
            getJdbcTemplate().batchUpdate("insert into "+defaultSchema+".s_g_ws_template_apps (s_template_id, s_app_id) values (?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    TemplateApp tApp = templateApps.get(i);
                    preparedStatement.setInt(1, k);
                    preparedStatement.setInt(2, tApp.getTemplateAppId());
                }

                @Override
                public int getBatchSize() {
                    return templateApps.size();
                }
            });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка создания шаблона: Ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int editTemplate(int groupId, String templateName, final List<TemplateApp> templateApps) {
        try {
            getJdbcTemplate().update("insert into "+defaultSchema+".s_g_ws_templates (s_group_id, s_name) values (?,?)");
            Integer k = getJdbcTemplate().queryForInt("select s_id from "+defaultSchema+".s_g_ws_templates where s_group_id=? and s_name=? and rownum<2 order by s_id desc ", groupId, templateName);
            getJdbcTemplate().update("delete from "+defaultSchema+".s_g_ws_templates_apps where s_id="+k);
            getJdbcTemplate().batchUpdate("insert into "+defaultSchema+".s_g_ws_template_apps (s_template_id, s_app_id) values (?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    TemplateApp tApp = templateApps.get(i);
                    preparedStatement.setInt(1, k);
                    preparedStatement.setInt(2, tApp.getTemplateAppId());
                }

                @Override
                public int getBatchSize() {
                    return templateApps.size();
                }
            });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка создания шаблона: Ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public List<TemplateApp> getAppsByWsId(int groupId, int wsId) {
        try {
            List<TemplateApp> result = new LinkedList<>();
            result.addAll(getJdbcTemplate().query("SELECT wsapps.S_ID, wsapps.s_name FROM "+defaultSchema+".s_g_ws_apps APPS " +
                    "LEFT JOIN "+defaultSchema+".s_ws_apps wsapps " +
                    "ON APPS.S_APP_ID=wsapps.S_ID " +
                    "WHERE S_GWS_ID=? " +
                    "ORDER BY s_app_id", new RowMapper<TemplateApp>() {
                @Override
                public TemplateApp mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new TemplateApp(
                            resultSet.getInt(1),
                            resultSet.getString(2)
                    );
                }
            }, groupId, wsId));
            return result;
        } catch (Exception e) {
            System.out.println("Ошибка получения списка приложений рабочего места: Ошибка синтаксиса Oracle");
            e.printStackTrace();
            return null;
        }
    }

    public int removeAppsFromWs(int wsId, List<Integer> list) {
        try {
            getJdbcTemplate().batchUpdate("delete from " + defaultSchema + ".s_g_ws_apps " +
                    "WHERE S_GWS_ID=? and s_app_id=?", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    preparedStatement.setInt(1, wsId);
                    preparedStatement.setInt(2, list.get(i));
                }

                @Override
                public int getBatchSize() {
                    return list.size();
                }
            });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка удаления приложений из рабочего места: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int addAppsToWs(int wsId, List<Integer> list) {
        try {
            getJdbcTemplate().batchUpdate("insert into " + defaultSchema + ".s_g_ws_apps " +
                    "(S_GWS_ID, s_app_id) values (?,?)", new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    preparedStatement.setInt(1, wsId);
                    preparedStatement.setInt(2, list.get(i));
                }

                @Override
                public int getBatchSize() {
                    return list.size();
                }
            });
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка добавления приложений в рабочее место: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }
}
