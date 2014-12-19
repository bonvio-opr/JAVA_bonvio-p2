package com.bonvio.project2.dao.cafe.barman.implementation;

import com.bonvio.project2.classes.cafe.clients.CafeMenu;
import com.bonvio.project2.classes.cafe.clients.CafeObject;
import com.bonvio.project2.classes.cafe.clients.CafeSector;
import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.classes.cafe.clients.extractors.CafeObjectDBExtractor;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.barman.CafeBarmanPagesDao;
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
import java.util.Random;

/**
 * Created by Arti on 31.07.14.
 */
public class CafeBarmanPagesDaoImpl extends BaseDao implements CafeBarmanPagesDao {

    @Autowired
    public CafeBarmanPagesDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public int getIdByEmail(String email) {
        try {return getJdbcTemplate().queryForObject("select S_ID from " + defaultSchema + ".s_users where s_phonenumber=?", Integer.class, email);}
        catch(Exception e) {e.printStackTrace();}
        return 0;
    }

    public CafeObject getCafeObject(String remoteAddr) {
        System.out.println("DEBUG: Incoming request from IP:"+remoteAddr+"; ");
        CafeObject cafeObject = new CafeObject();
        String q = "select  " +
//                    "SPOTS.S_ID as SPOT_ID,  " +
                "SPOTS.S_NAME as SPOT_NAME, " +
                "SPOTS.S_COORDS as SPOT_COORDS, " +
                "SPOTS.S_ADDRESS as SPOT_ADDRESS, " +
                "SECTORS.S_ID as SECTOR_ID, " +
                "SECTORS.S_IP as SECTOR_IP, " +
                "SECTORS.S_NAME as SECTOR_NAME, " +
                "MU.S_NAME as MENU_NAME, " +
                "MU.S_CODE as MENU_CODE, " +
                "PBC.S_POSITION_ID as POS_ID, " +
                "POS.S_NAME as POS_NAME, " +
                "POS.S_DESCRIPTION as POS_DESCR, " +
                "POS.S_PRICE as POS_PRICE, " +
                "POS.S_LANGUAGE_ID as POS_LANG, " +
                "POS.S_QUANTITY as POS_QUANTITY, " +
                "POS.S_PICTURE as POS_PICTURE, " +
                "POS.S_INCLUDED as POS_INCLUDED, " +
                "POS.S_UNITS as POS_UNITS, " +
                "MU.S_TYPE as MENU_TYPE " +
                "from  " +
                defaultSchema+".S_CAFE_SPOTS SPOTS " +
                "left join " +
                defaultSchema+".S_CAFE_SPOT_SECTORS SECTORS " +
                "on  " +
                "SPOTS.S_ID=SECTORS.S_CAFE_SPOT_ID " +
                "left join " +
                defaultSchema+".S_CAFE_MENU_UNITS MU " +
                "on  " +
                "MU.S_CAFE_SECTOR_ID=SECTORS.S_ID " +
                "left join  " +
                defaultSchema+".S_CAFE_POSITIONS_BY_CATEGORIES PBC " +
                "on " +
                "PBC.S_CATEGORY_ID=MU.S_ID " +
                "left join " +
                defaultSchema+".S_CAFE_MENU_UNITS_POSITIONS POS " +
                "on " +
                "POS.S_ID=PBC.S_ID " +
                "where  SECTORS.S_IP=?";
        ArrayList<CafeObjectDBExtractor> tList = new ArrayList<CafeObjectDBExtractor>();
        tList.addAll(getJdbcTemplate().query(q, new RowMapper<CafeObjectDBExtractor>() {
            @Override
            public CafeObjectDBExtractor mapRow(ResultSet r, int i) throws SQLException {
                return new CafeObjectDBExtractor(
                        r.getString("SPOT_NAME"),
                        r.getString("SPOT_NAME"),
                        r.getString("SECTOR_NAME"),
                        r.getString("SECTOR_IP"),
                        r.getString("MENU_NAME"),
                        r.getString("MENU_CODE"),
                        r.getString("POS_ID"),
                        r.getString("POS_LANG"),
                        r.getString("POS_NAME"),
                        r.getString("POS_DESCR"),
                        r.getBlob("POS_PICTURE"),
                        r.getDouble("POS_PRICE"),
                        r.getDouble("POS_QUANTITY"),
                        r.getString("POS_UNITS"),
                        r.getInt("POS_INCLUDED"),
                        r.getInt("MENU_TYPE")
                );
            }
        }, remoteAddr));
        System.out.println(tList);
        ArrayList<CafeSector> sectors = new ArrayList<CafeSector>();
        CafeSector sector = new CafeSector();
        if(tList.size()>0) {
            cafeObject.setCafeName(tList.get(0).getCafeName());
            cafeObject.setSpotName(tList.get(0).getSpotName());
            sector.setSectorIp(tList.get(0).getSectorIp());
            sector.setSectorName(tList.get(0).getSectorName());
        } else {
            return null;
        }
        ArrayList<CafeMenu> spotMenues = new ArrayList<CafeMenu>();
        CafeMenu tmpMenu = new CafeMenu();
        String catName = "",
                catCode = "";
        ArrayList<MenuPosition> mpList = new ArrayList<>();
        for(int i=0; i<tList.size(); i++) {
            CafeObjectDBExtractor codb = tList.get(i);
            MenuPosition pos = new MenuPosition();
            if(i==0) {
                catName = codb.getCatName();
                catCode = codb.getCatCode();
            } else if(!tList.get(i-1).getCatName().equals(codb.getCatName())){
                //Переход на другую категорию
                spotMenues.add(new CafeMenu(tList.get(i-1).getCatName(), tList.get(i-1).getCatCode(), new ArrayList<>(mpList)));
                mpList.clear();
                catName = codb.getCatName();
                catCode = codb.getCatCode();
            } else if(i==tList.size()-1) {
                mpList.add(new MenuPosition(
                                new Long(codb.getPosId()),
                                codb.getPosLang(),
                                codb.getPosName(),
                                codb.getPosPrice(),
                                codb.getPosDescription(),
                                codb.getPosPictureLink(),
                                codb.getPosQuantity(),
                                codb.getPosUnits(),
                                "",
                                0,
                                codb.getPosIncluded(),
                                codb.getPosCatType()
                        )
                );
                spotMenues.add(new CafeMenu(tList.get(i).getCatName(), tList.get(i).getCatCode(), new ArrayList<>(mpList)));
                break;
            }
            //Категория та же самая
            mpList.add(new MenuPosition(
                            new Long(codb.getPosId()),
                            codb.getPosLang(),
                            codb.getPosName(),
                            codb.getPosPrice(),
                            codb.getPosDescription(),
                            codb.getPosPictureLink(),
                            codb.getPosQuantity(),
                            codb.getPosUnits(),
                            "",
                            0,
                            codb.getPosIncluded(),
                            codb.getPosCatType()
                    )
            );
        }
        sectors.add(sector);
        sector.setListOfMenues(spotMenues);
        cafeObject.setCafeSectors(sectors);
        System.out.println(cafeObject);
        return cafeObject;
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
//        int regState = groupsManagement.checkUserData(name, phone);
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
