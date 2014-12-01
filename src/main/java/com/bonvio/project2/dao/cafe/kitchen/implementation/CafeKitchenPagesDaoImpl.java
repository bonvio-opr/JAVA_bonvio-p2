package com.bonvio.project2.dao.cafe.kitchen.implementation;

import com.bonvio.project2.classes.cafe.waiters.CafeWaiterObject;
import com.bonvio.project2.classes.cafe.waiters.NamedPositionWithQuantity;
import com.bonvio.project2.classes.cafe.waiters.extractors.OrdersWithTableNamesDBExtractor;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.kitchen.CafeKitchenPagesDao;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Arti on 11.08.2014.
 */
public class CafeKitchenPagesDaoImpl extends BaseDao implements CafeKitchenPagesDao {
    @Autowired
    public CafeKitchenPagesDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public ArrayList<Integer> getFreeTablesArray(String ip) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(getJdbcTemplate().query("select distinct O.S_TABLE_NUM from "+defaultSchema+".s_cafe_orders O where s_date_close is null and O.S_DATE_OPEN>SYSDATE-1 and O.S_DATE_OPEN<SYSDATE+10/1440",
                new RowMapper<Integer>() {
                    @Override
                    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getInt(1);
                    }
                }));
        Integer capacity = getJdbcTemplate().queryForInt("select s_capacity from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?", ip);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<=capacity; i++) {
            if(!list.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public int getUserUnitAccessRights(int wsId, String unitCode, String userId) {
        String q;
        try {
            q = "select count(*) from ( " +
                    "select " +
                    "gws.S_ID, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS from "+defaultSchema+".s_g_ws gws " +
                    "left join "+defaultSchema+".S_G_WS_APPS ga " +
                    "on " +
                    "gws.S_ID=ga.S_GWS_ID " +
                    "left join "+defaultSchema+".S_WS_APPS APPS " +
                    "on " +
                    "ga.S_APP_ID=APPS.S_ID " +
                    "left join "+defaultSchema+".s_users U " +
                    "on " +
                    "U.S_ID=gws.S_USER_ID " +
                    "where " +
                    "GWS.S_ID=? and APPS.S_CODE=? and U.S_ID=? " +
                    "group by " +
                    "gws.s_id, gws.S_WS_NAME, APPS.S_NAME, APPS.S_CODE, APPS.S_APP_ADDRESS)";
            return (getJdbcTemplate().queryForInt(q, userId, wsId, unitCode)>0) ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<OrdersWithTableNamesDBExtractor> getCafeKitchenObjectInfo(String ip) {
        CafeWaiterObject c = new CafeWaiterObject();
        String q = "select s_name, s_capacity from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?";
        c = getJdbcTemplate().queryForObject(q, new RowMapper<CafeWaiterObject>() {
            @Override
            public CafeWaiterObject mapRow(ResultSet resultSet, int i) throws SQLException {
                return new CafeWaiterObject(
                        resultSet.getInt(2),
                        resultSet.getString(1),
                        null
                );
            }
        }, ip);
        HashMap<Integer, ArrayList<NamedPositionWithQuantity>> map = new HashMap<Integer, ArrayList<NamedPositionWithQuantity>>();
        ArrayList<OrdersWithTableNamesDBExtractor> extList = new ArrayList<OrdersWithTableNamesDBExtractor>();
        q = "select  " +
                "O.S_ID, " +
                "O.S_TABLE_NUM, " +
                "O.S_DATE_OPEN, " +
                "P.S_DATE, " +
                "P.S_POSITION_ID, " +
                "P.S_QUANT, " +
                "M.S_NAME, " +
                "M.S_PRICE, " +
                "P.s_status, " +
                "P.S_ID " +
                "from  " +
                defaultSchema+".S_CAFE_ORDERS O " +
                "left join " +
                defaultSchema+".S_CAFE_ORDER_POSITIONS P " +
                "on O.S_ID=P.S_ORDER_ID " +
                "left join "+defaultSchema+".S_CAFE_MENU_UNITS_POSITIONS M on M.S_ID=P.S_POSITION_ID "+
                "where O.S_IP=?  and NOT(P.S_POSITION_ID is null) and O.S_DATE_CLOSE is null " +
                "group by O.S_ID, O.S_TABLE_NUM, O.S_TABLE_NUM, P.S_POSITION_ID, P.s_status, P.S_QUANT, O.S_DATE_OPEN, P.S_DATE, M.S_NAME, M.S_PRICE, P.S_ID  " +
                "order by O.S_ID";
        extList.addAll(getJdbcTemplate().query(q, new RowMapper<OrdersWithTableNamesDBExtractor>() {
            @Override
            public OrdersWithTableNamesDBExtractor mapRow(ResultSet r, int i) throws SQLException {
                return new OrdersWithTableNamesDBExtractor(
                        r.getInt(10),
                        r.getInt(2),
                        r.getInt(1),
                        r.getInt(5),
                        r.getString(7),
                        r.getDouble(6),
                        r.getTimestamp(4),
                        r.getInt(9)
                );
            }
        }, ip));
//        ArrayList<NamedPositionWithQuantity> npwq = new ArrayList<NamedPositionWithQuantity>();
        return extList;
    }

    public int checkCredentials(String number, String password) {

        if(getJdbcTemplate().queryForInt("select count (*) from "+defaultSchema+".s_users where s_phonenumber=?", number)>0) {
            try {
                Integer exists = getJdbcTemplate().queryForInt("select count(*) from " + defaultSchema + ".s_users where s_phonenumber=? and s_password=?", number, password);
                if (exists == 1) {
                    System.out.println(number + ": успешная авторизация");
                    return 1;
                } else {
                    System.out.println(number + ": неверный пароль");
                    return 2;
                }
            } catch (Exception e) {
                //Неверный пароль:
                System.out.println(number+": неверный пароль: "+password);
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
        String msgText = pCode+" - для продолжения регистрации используйте этот четырёхзначный код. С уважением, ваш BONVIO.net";
//        String msgText = "Добро пожаловать на BONVIO.net! Для авторизации используйте следующий пароль: "+pCode;
        StringBuffer response = new StringBuffer();
        String result="";
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            JSONObject object = new JSONObject();
            object.put("login", "t89214295194");
            object.put("password", "175319");
            object.put("statusQueueName", "myQueue1");
            JSONObject message = new JSONObject();
            message.put("phone", "+7"+phone);
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
            JSONArray array = (JSONArray)jsonObj.get("messages");
            String status = ((JSONObject) parser.parse(array.get(0).toString())).get("status").toString();
            in.close();
            if(status.equals("accepted")) {
//                insertUserTempCode(phone, pCode, password);
                if(getJdbcTemplate().queryForInt("select count(*) from " + defaultSchema + ".s_users_unconfirmed where s_user_phone=?", phone)>0) {
                    getJdbcTemplate().update("UPDATE "+defaultSchema+".S_USERS_UNCONFIRMED SET S_CODE=?, S_DATE=SYSDATE, S_PWD=? WHERE S_USER_PHONE = ?", pCode, password, phone);
                } else {
                    getJdbcTemplate().update("INSERT INTO "+defaultSchema+".S_USERS_UNCONFIRMED (S_USER_PHONE, S_CODE, S_PWD) VALUES (?,?,?)", phone, pCode, password);
                }
                return 4;
            } else if(status.equals("invalid mobile phone")) {
                return 5;
            } else {
                return 6;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 6;
        }
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
}
