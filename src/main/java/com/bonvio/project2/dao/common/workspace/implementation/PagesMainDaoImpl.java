package com.bonvio.project2.dao.common.workspace.implementation;

import com.bonvio.project2.classes.common.workspace.*;
import com.bonvio.project2.classes.common.workspace.extractors.WorkspaceWithApplicationsDBExtractor;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.common.workspace.PagesMainDao;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Arti on 07.07.2014.
 */
public class PagesMainDaoImpl extends BaseDao implements PagesMainDao {


    public PagesMainDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public int checkCredentials(String number, String password) {

        if (getJdbcTemplate().queryForInt("select count (*) from " + defaultSchema + ".s_users where s_phonenumber=?", number) > 0) {
            //Integer exists = getJdbcTemplate().queryForInt("select count(*) from " + defaultSchema + ".s_users where s_phonenumber=? and s_password=?", number, password);
            try {
                Integer exists = getJdbcTemplate().queryForInt("select count(*) from " + defaultSchema + ".s_users where s_phonenumber=? and s_password=?", number, password);
                System.out.println("exists = " + exists);
                if (exists == 1) {
                    System.out.println(number + ": успешная авторизация");
                    return 1;
               /* } else if(exists != 1.0D){
                    System.out.println(number + ": учетная запись заблокирована администратором");
                    return 3;*/
                } else {
                    System.out.println(number + ": неверный пароль");
                    return 2;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(number + ": неверный пароль: " + password);
                return 2;
            }
        } else {
            //Инициируем процесс регистрации
            return sendRegistrationCode(number, password);
        }
    }

    public int sendRegistrationCode(String phone, String password) {
//        int regState = dao.checkUserData(name, phone);
        String url = "http://api.prostor-sms.ru/messages/v2/send.json";
        String pCode = genPass();
        String msgText = pCode + " - для продолжения регистрации используйте этот четырёхзначный код. С уважением, ваш BONVIO.net";
//        String msgText = "Добро пожаловать на BONVIO.net! Для авторизации используйте следующий пароль: "+pCode;
        StringBuffer response = new StringBuffer();
        String result = "";
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            JSONObject object = new JSONObject();
            object.put("login", "t89214295194");
            object.put("password", "175319");
            object.put("statusQueueName", "myQueue1");
            JSONObject message = new JSONObject();
            message.put("phone", "+7" + phone);
            message.put("sender", "BONVIO.net");
            message.put("clientId", "2");
            message.put("text", msgText);
            JSONArray arr = new JSONArray();
            arr.add(message);
            object.put("messages", arr);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            ObjectMapper mapper = new ObjectMapper();
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            mapper.writeValue(dos, object);
            dos.flush();
            dos.close();
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            JSONParser parser = new JSONParser();
            Object r = parser.parse(response.toString());
            JSONObject jsonObj = (JSONObject) r;
            JSONArray array = (JSONArray) jsonObj.get("messages");
            String status = ((JSONObject) parser.parse(array.get(0).toString())).get("status").toString();
            in.close();
            if (status.equals("accepted")) {
//                insertUserTempCode(phone, pCode, password);
                if (getJdbcTemplate().queryForInt("select count(*) from " + defaultSchema + ".s_users_unconfirmed where s_user_phone=?", phone) > 0) {
                    getJdbcTemplate().update("UPDATE " + defaultSchema + ".S_USERS_UNCONFIRMED SET S_CODE=?, S_DATE=SYSDATE, S_PWD=? WHERE S_USER_PHONE = ?", pCode, password, phone);
                } else {
                    getJdbcTemplate().update("INSERT INTO " + defaultSchema + ".S_USERS_UNCONFIRMED (S_USER_PHONE, S_CODE, S_PWD) VALUES (?,?,?)", phone, pCode, password);
                }
                return 4;
            } else if (status.equals("invalid mobile phone")) {
                return 5;
            } else {
                return 6;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 6;
        }
    }

    public int checkConfirmationCode(String number, String code) {
        try {
            return (getJdbcTemplate().queryForInt("select count (*) from " + defaultSchema + ".s_users_unconfirmed where s_user_phone=? and s_code=?", number, code));
        } catch (Exception e) {
            return 0;
        }
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

    private String genPass() {
        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public List<WorkspaceApplicationsWithType> getWorkspaces(String userId) {

        if (userId == null) return null;

        ArrayList<WorkspaceApplicationsWithType> workspaceApplicationsWithTypes = new ArrayList<>();
        workspaceApplicationsWithTypes.addAll(getJdbcTemplate().query(
                "select " +
                        "UWS.S_ID as WSID, " +
                        "UWS.S_WS_NAME as WSNAME, " +
                        "'p' as WSTYPE " +
                        "from s_u_ws UWS " +
                        "left join s_users U " +
                        "on U.S_ID=UWS.S_USER_ID " +
                        "where U.S_ID=? " +
                        "union " +
                        "select gws.S_ID as WSID, " +
                        "gws.S_WS_NAME as WSNAME, " +
                        "'a' as WSTYPE " +
                        "from " +
                        "s_g_ws gws " +
                        "where gws.S_USER_ID=? ",
                new RowMapper<WorkspaceApplicationsWithType>() {
                    @Override
                    public WorkspaceApplicationsWithType mapRow(ResultSet r, int i) throws SQLException {
                        return new WorkspaceApplicationsWithType(
                                r.getInt("WSID"),
                                r.getString("WSNAME"),
                                r.getString("WSTYPE")
                        );
                    }
                }, userId, userId));

        return workspaceApplicationsWithTypes;
    }


    public Window getWindow(int unitID) {

        Window window = new Window();
        window.setOwnerUnitId(unitID);
        window.setWindowPositionX(100);
        window.setWindowPositionY(100);
        window.setWindowWidth(799);
        window.setWindowHeight(400);
        window.setIsMax(0);
        window.setIsMin(1);
        window.setTitle("Дефолтное название");
        window.setState("Че за state?");
        window.setzIndex(0);

        /* работает, проверить на БД

        DECLARE
 id number;
BEGIN
insert into s_window (OWNERUNITID, windowpositionx, windowpositiony, WINDOWWIDTH, WINDOWHEIGHT, windowtitle, windowstate, ismax, ismin, zindex) values (1,1,2,2,5,'aaaaaaaa','df',5,5,5)
RETURNING WINDOWID INTO id;
dbms_output.put_line(id);
END;
        * */


/*
insert into s_window (ownerunitid, windowpositionx, windowpositiony, WINDOWWIDTH, WINDOWHEIGHT, windowtitle, windowstate, ismax, ismin, zindex) values (1,1,2,2,5,'df','df',5,5,5);
COMMIT;
select S_WINDOW_SEQ.currval from dual;*/

        try {
            getJdbcTemplate().update("insert into " + defaultSchema + ".s_window " +
                    "(ownerunitid, windowpositionx, windowpositiony, windowwidth, windowheight, windowtitle, windowstate, ismax, ismin, zindex) " +
                    "values (?,?,?,?,?,?,?,?,?,?) ",
                    new Object[]{
                    window.getOwnerUnitId(),
                    window.getWindowPositionX(),
                    window.getWindowPositionY(),
                    window.getWindowWidth(),
                    window.getWindowHeight(),
                    window.getTitle(),
                    window.getState(),
                    window.getIsMax(),
                    window.getIsMin(),
                    window.getzIndex()
            });
        } catch (Exception ept) {
            System.out.println("ошибка в создании окна");
        }


        try {
            int windowId = getJdbcTemplate().queryForInt("select S_WINDOW_SEQ.currval as ownerunitid from dual");
            window.setWindowId(windowId);
        } catch (Exception ept) {
            System.out.println("ошибка в присвоении Ид окна");
        }



        return window;

 /*       try {

        getJdbcTemplate().update("insert into " + defaultSchema + ".s_window " +
                "(windowid, ownerunitid, windowpositionx, windowpositiony, windowwidth, windowheight, windowtitle, windowstate, ismax, ismin, zindex) " +
                "values (?,?,?,?,?,?,?,?,?,?,?)", new Object []{
                window.getWindowId(),
                window.getOwnerUnitId(),
                window.getWindowPositionX(),
                window.getWindowPositionY(),
                window.getWindowWidth(),
                window.getWindowHeight(),
                window.getTitle(),
                window.getState(),
                window.getIsMax(),
                window.getIsMin(),
                window.getzIndex()
        });

            return 1;

        } catch (Exception ept) {
            System.out.println("ошибка в создании окна");
            return 0;
        }*/
    }

    public int updateWindow(Window window) {

        String query =
                "UPDATE s_window SET " +
                        "ownerunitid = ?, windowpositionx = ?, windowpositiony = ?, windowwidth = ?, windowheight = ?, windowtitle = ?, windowstate = ?, ismax = ?, ismin = ?, zindex = ? " +
                        "WHERE windowid = ?";
        try {
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            window.getOwnerUnitId(),
                            window.getWindowPositionX(),
                            window.getWindowPositionY(),
                            window.getWindowWidth(),
                            window.getWindowHeight(),
                            window.getTitle(),
                            window.getState(),
                            window.getIsMax(),
                            window.getIsMin(),
                            window.getzIndex(),
                            window.getWindowId()
                    }
            );
            return 1;
        } catch (Exception ept) {
            System.out.println("ошибка при обновлении окна!");
            ept.printStackTrace();
            return 0;
        }
    }

    public int deleteWindow(Window window) {

        String query = "DELETE FROM s_window WHERE windowid = ?";
        try {
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            window.getWindowId()
                    }
            );
            return 1;
        } catch (Exception ept) {
            System.out.println("ошибка при удалении окна!");
            ept.printStackTrace();
            return 0;
        }
    }


    public int updateApplicationPosition(Application application) {

        String query =
                "UPDATE S_WS_APPS SET " +
                        "S_APP_POSITION_X = ?, " +
                        "S_APP_POSITION_Y = ? " +
                        "WHERE S_ID = ?";
        try {
            getJdbcTemplate().update(
                    query,
                    new Object[]{
                            application.getUnitPositionX(),
                            application.getUnitPositionY(),
                            application.getUnitId()}
            );
            return 1;
        } catch (Exception ept) {
            ept.printStackTrace();
            return 0;
        }
    }

    public List<Window> getWindowByOwnerWindowId(int id) {


        try {
            List<Window> applications = new ArrayList<Window>();
            applications.addAll(getJdbcTemplate().query(
                    "select * from s_window  where ownerunitid = ?",
                    new RowMapper<Window>() {
                        @Override
                        public Window mapRow(ResultSet r, int i) throws SQLException {
                            return new Window(
                                    r.getInt("WINDOWID"),
                                    r.getInt("OWNERUNITID"),
                                    r.getInt("WINDOWPOSITIONX"),
                                    r.getInt("WINDOWPOSITIONY"),
                                    r.getInt("WINDOWWIDTH"),
                                    r.getInt("WINDOWHEIGHT"),
                                    r.getString("WINDOWTITLE"),
                                    r.getString("WINDOWSTATE"),
                                    r.getInt("ISMAX"),
                                    r.getInt("ISMIN"),
                                    r.getInt("ZINDEX")
                            );
                        }
                    }, id));

            return applications;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }


    public List<Application> getPrivateApplications(String wsId, String userId) {

        if (wsId == null) return null;

        ArrayList<Application> applications = new ArrayList<>();
        applications.addAll(getJdbcTemplate().query(
                "select " +
                        "APPS.S_NAME as APPNAME, " +
                        "APPS.S_CODE as APPCODE, " +
                        "APPS.S_APP_ADDRESS as IMGPATH, " +
                        "APPS.S_ID as APPID, " +
                        "APPS.S_APP_IMAGE as APPIMAGE, " +
                        "APPS.S_APP_POSITION_X as APPX, " +
                        "APPS.S_UNIT_TYPE as UNITTYPE, " +
                        "APPS.S_APP_POSITION_Y as APPY " +
                        "from s_u_ws UWS " +
                        "left join s_users U " +
                        "on U.S_ID=UWS.S_USER_ID " +
                        "left join S_U_WS_APPS UWSAPPS " +
                        "on UWS.S_ID=UWSAPPS.S_WS_ID " +
                        "left join S_WS_APPS APPS " +
                        "on UWSAPPS.S_APP_ID=APPS.S_ID " +
                        "where UWS.S_ID=? and U.S_ID=?",

             /*   "select " +
                        "APPS.S_NAME as APPNAME, " +
                        "APPS.S_CODE as APPCODE, " +
                        "APPS.S_APP_ADDRESS as IMGPATH " +
                        "from s_u_ws UWS " +
                        "left join s_users U " +
                        "on U.S_ID=UWS.S_USER_ID " +
                        "left join S_U_WS_APPS UWSAPPS " +
                        "on UWS.S_ID=UWSAPPS.S_WS_ID " +
                        "left join S_WS_APPS APPS " +
                        "on UWSAPPS.S_APP_ID=APPS.S_ID " +
                        "where UWS.S_ID=? and U.S_ID=?",
                */

                new RowMapper<Application>() {
                    @Override
                    public Application mapRow(ResultSet r, int i) throws SQLException {
                        return new Application(
                                r.getInt("APPID"),
                                r.getString("APPNAME"),
                                r.getString("APPCODE"),
                                r.getString("IMGPATH"),
                                r.getInt("APPX"),
                                r.getInt("APPY"),
                                r.getInt("UNITTYPE")
                        );
                    }
                }, wsId, userId));

        for (int i = 0; i < applications.size(); i++) {
            applications.get(i).setWindows(getWindowByOwnerWindowId(applications.get(i).getUnitId()));
        }

        return applications;
    }

    public List<Application> getAdditionalApplications(String wsId, String userId) {

        if (wsId == null) return null;

        ArrayList<Application> applications = new ArrayList<>();
        applications.addAll(getJdbcTemplate().query(
                "select \n" +
                        "APPS.S_NAME as APPNAME, " +
                        "APPS.S_CODE as APPCODE, " +
                        "APPS.S_APP_ADDRESS as IMGPATH  " +
                        "from " +
                        "s_g_ws gws " +
                        "left join S_G_WS_APPS ga " +
                        "on gws.S_ID=ga.S_GWS_ID " +
                        "left join S_WS_APPS APPS " +
                        "on ga.S_APP_ID=APPS.S_ID " +
                        "left join s_users U " +
                        "on U.S_ID=gws.S_USER_ID " +
                        "where gws.S_ID=? and U.S_ID=?",
                new RowMapper<Application>() {
                    @Override
                    public Application mapRow(ResultSet r, int i) throws SQLException {
                        return new Application(
                                r.getString("APPNAME"),
                                r.getString("APPCODE"),
                                r.getString("IMGPATH")
                        );
                    }
                }, wsId, userId));

        return applications;
    }


    //old
    public ArrayList<WorkspaceWithApplications> getUserPrivateWorkspace(String userId, String userPhoneNumber) {
//    public WorkspaceWithApplications getUserPrivateWorkspace(String userNum) {
        ArrayList<WorkspaceWithApplications> wList = new ArrayList<WorkspaceWithApplications>();
        ArrayList<WorkspaceWithApplicationsDBExtractor> wdb = new ArrayList<>();
        wdb.addAll(getJdbcTemplate().query(
                "select " +
                        "UWS.S_ID as WSID, " +
                        "UWS.S_WS_NAME as WSNAME, " +
                        "APPS.S_NAME as APPNAME, " +
                        "APPS.S_CODE as APPCODE, " +
//                "concat(concat('resources/image/icons/',APPS.S_CODE),'.png') as IMGPATH " +
                        "APPS.S_CODE as IMGPATH " +
                        "from " + defaultSchema + ".s_u_ws UWS " +
                        "left join " + defaultSchema + ".s_users U " +
                        "on U.S_ID=UWS.S_USER_ID " +
                        "left join " + defaultSchema + ".S_U_WS_APPS UWSAPPS " +
                        "on UWS.S_ID=UWSAPPS.S_WS_ID " +
                        "left join " + defaultSchema + ".S_WS_APPS APPS " +
                        "on UWSAPPS.S_APP_ID=APPS.S_ID " +
                        "where U.S_ID=? and U.S_PHONENUMBER=? " +
                        "group by UWS.S_ID, UWS.S_WS_NAME, APPS.S_NAME, APPS.S_CODE order by UWS.S_ID",
                new RowMapper<WorkspaceWithApplicationsDBExtractor>() {
                    @Override
                    public WorkspaceWithApplicationsDBExtractor mapRow(ResultSet r, int i) throws SQLException {
                        return new WorkspaceWithApplicationsDBExtractor(
                                r.getInt("WSID"),
                                r.getString("WSNAME"),
                                r.getString("APPNAME"),
                                r.getString("APPCODE"),
                                r.getString("IMGPATH")
                        );
                    }
                }, userId, userPhoneNumber));
        //WorkspaceWithApplicationsDBExtractor -> WorkspaceWithApplications
        WorkspaceWithApplications w = new WorkspaceWithApplications();
        if (wdb.size() > 0) {
            w.setWsId(wdb.get(0).getWorkspaceId());
            w.setWsName(wdb.get(0).getWorkspaceName());
            ArrayList<Application> appList = new ArrayList<>();
            for (int i = 0; i < wdb.size(); i++) {
                appList.add(new Application(wdb.get(i).getUnitName(), wdb.get(i).getUnitCode(), wdb.get(i).getUnitImgPath()));
            }
            w.setWsUnits(appList);
            wList.add(w);
            return wList;
        } else
            return null;
    }


    //old
    public ArrayList<WorkspaceWithApplications> getUserAdditionalWorkspaces(String userId, String userPhoneNumber) {
        ArrayList<WorkspaceWithApplications> list = new ArrayList<>();
        ArrayList<WorkspaceWithApplicationsDBExtractor> extractor = new ArrayList<>();
        String q =
                "select " +
                        "gws.S_ID, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS " +
                        "from " +
                        "s_g_ws gws " +
                        "left join S_G_WS_APPS ga " +
                        "on gws.S_ID=ga.S_GWS_ID " +
                        "left join S_WS_APPS APPS " +
                        "on ga.S_APP_ID=APPS.S_ID " +
                        "left join s_users U " +
                        "on U.S_ID=gws.S_USER_ID " +
                        "where " +
                        "GWS.S_USER_ID=? and U.S_PHONENUMBER=? and GWS.S_ACTIVE>0 " +
                        "group by " +
                        "gws.s_id, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS " +
                        "order by APPS.S_NAME";
        extractor.addAll(getJdbcTemplate().query(q, new RowMapper<WorkspaceWithApplicationsDBExtractor>() {
            @Override
            public WorkspaceWithApplicationsDBExtractor mapRow(ResultSet resultSet, int i) throws SQLException {
                return new WorkspaceWithApplicationsDBExtractor(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
        }, Integer.parseInt(userId), userPhoneNumber));
        WorkspaceWithApplicationsDBExtractor w = new WorkspaceWithApplicationsDBExtractor();
        int currWsid = -1;
        String currWsName = "";
        ArrayList<Application> appList = new ArrayList<>();
        for (int i = 0; i < extractor.size() - 1; i++) {
            w = extractor.get(i);
            if (i == 0) {
                currWsid = w.getWorkspaceId();
                currWsName = w.getWorkspaceName();
                appList.add(new Application(w.getUnitName(), w.getUnitCode(), w.getUnitImgPath()));
            } else {
                if (w.getWorkspaceId() == currWsid) {
                    appList.add(new Application(w.getUnitName(), w.getUnitCode(), w.getUnitImgPath()));
                } else {
                    list.add(new WorkspaceWithApplications(
                            currWsid,
                            currWsName,
                            appList
                    ));
                    appList.clear();
                    appList.add(new Application(w.getUnitName(), w.getUnitCode(), w.getUnitImgPath()));
                    currWsid = w.getWorkspaceId();
                    currWsName = w.getWorkspaceName();
                }
            }
        }
        System.out.println(extractor.size());
        appList.add(new Application(extractor.get(extractor.size() - 1).getUnitName(), extractor.get(extractor.size() - 1).getUnitCode(), extractor.get(extractor.size() - 1).getUnitImgPath()));
        list.add(new WorkspaceWithApplications(
                currWsid,
                currWsName,
                appList
        ));
        return list;
    }

    public UserCredentials getCurrentUserCredentials(String userId, String userPhoneNumber) {
        /*ArrayList<UserCredentials> userCredentials = new ArrayList<>();
        userCredentials.addAll(getJdbcTemplate().query("select s_id, s_first_name, s_second_name from " + defaultSchema + ".s_users where s_phonenumber=" + userId, new RowMapper<UserCredentials>() {
            @Override
            public UserCredentials mapRow(ResultSet resultSet, int i) throws SQLException {
                return new UserCredentials(
                        resultSet.getInt("s_id"),
                        resultSet.getString("s_first_name"),
                        resultSet.getString("s_second_name"),
                        userId
                );
            }
        }));
        return userCredentials.get(0);*/

        return getJdbcTemplate().queryForObject("select s_id, s_first_name, s_second_name from " + defaultSchema + ".s_users where s_id=? and s_phonenumber=?", new RowMapper<UserCredentials>() {
            @Override
            public UserCredentials mapRow(ResultSet resultSet, int i) throws SQLException {
                return new UserCredentials(
                        resultSet.getInt("s_id"),
                        resultSet.getString("s_first_name"),
                        resultSet.getString("s_second_name"),
                        userPhoneNumber
                );
            }
        }, userId, userPhoneNumber);
    }

    public int getUserUnitAccessRights(Integer wsId, String unitCode, String userId) {
        String q;
        try {
            q =
                    "select " +
                            "count (*) " +
                            "from " + defaultSchema + ".s_g_ws gws " +
                            "left join " + defaultSchema + ".S_G_WS_APPS ga " +
                            "on " +
                            "gws.S_ID=ga.S_GWS_ID " +
                            "left join " + defaultSchema + ".S_WS_APPS APPS " +
                            "on " +
                            "ga.S_APP_ID=APPS.S_ID " +
                            "left join " + defaultSchema + ".s_users USRS " +
                            "on " +
                            "USRS.S_ID=gws.S_USER_ID " +
                            "where " +
                            "GWS.S_ID=? and APPS.S_CODE=? and USRS.S_ID=?";



/*                    "group by " +
                        "gws.s_id, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS)";
            /*if (wsId == 0) {
                q = "select count(*) from "+defaultSchema+".s_u_ws ws " +
                        "left join "+defaultSchema+".s_u_ws_apps apps " +
                        "on ws.S_ID=apps.S_WS_ID " +
                        "left join "+defaultSchema+".s_ws_apps WSAPPS " +
                        "on apps.S_APP_ID=WSAPPS.S_ID " +
                        "where ws.S_USER_ID=? and ws.S_ID=? and wsapps.s_code=?";
            } else {
                q = "select count(*) from ( " +
                        "select gws.S_ID, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS from "+defaultSchema+".s_g_ws gws " +
                        "left join "+defaultSchema+".S_G_WS_APPS ga " +
                        "on gws.S_ID=ga.S_GWS_ID " +
                        "left join "+defaultSchema+".S_WS_APPS APPS " +
                        "on ga.S_APP_ID=APPS.S_ID " +
                        "left join "+defaultSchema+".s_users U " +
                        "on U.S_ID=gws.S_USER_ID " +
                        "where GWS.S_ID=? and APPS.S_CODE=? and U.S_ID=? " +
                        "group by gws.s_id, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS)";
            }*/
            ArrayList<Integer> iList = new ArrayList<>();
            iList.addAll(getJdbcTemplate().query(q, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getInt(1);
                }
            }, wsId, unitCode, Integer.parseInt(userId)));
            System.out.println(q);
            return (iList.get(0) > 0) ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getUserIdByPhoneNumber(String number) {
        String q = "select s_id from " + defaultSchema + ".s_users where s_phonenumber=?";
        try {
            ArrayList<Integer> gList = new ArrayList<>();
            gList.addAll(getJdbcTemplate().query(q, new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getInt(1);
                }
            }, number));
            return gList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
