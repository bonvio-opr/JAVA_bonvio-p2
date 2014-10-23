package com.bonvio.project2.dao.cafe.events.implementation;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.events.CafeEventsDao;
import org.springframework.jdbc.core.RowMapper;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 18.08.2014.
 */
public class CafeEventsDaoImpl extends BaseDao implements CafeEventsDao {
    public CafeEventsDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public List<InternalEvent> getEvents(int cafeSpotId, String myCurrentAccountRole, Integer myCurrentAccountId, String myCurrentAccountPhoneNumber) {
        LinkedList<InternalEvent> iEvents = new LinkedList<>();
        String q = "";
        if(myCurrentAccountRole.toLowerCase().contains("c")) {            //ЕСЛИ ТЕКУЩИЙ ПОЛЬЗОВАТЕЛЬ КЛИЕНТ
//            q = "select * from " + defaultSchema + ".s_cafe_events where s_date>=trunc(SYSDATE) and S_EXPOSED <> 0 and S_DELETED <> 0 order by s_date";
            q = "select " +
                    "EV.S_ID, " +
                    "EV.S_DATE, " +
                    "EV.S_EVENT_TYPE, " +
                    "EV.S_EVENT_SOURCE, " +
                    "EV.S_EVENT_HEADER, " +
                    "EV.S_EVENT_CONTENT, " +
                    "EV.S_EVENT_SPOT_ID, " +
                    "EV.S_EXPOSED, " +
                    "EV.S_DELETED, " +
                    "EV.S_SERV_ID " +
                    "from s_cafe_events EV " +
                    "left join S_CAFE_ORDERS ORD " +
                    "on EV.S_SERV_ID=ORD.S_ID " +
                    "where (EV.S_EVENT_TYPE=27 " +
                    "and EV.S_DELETED=0 " +
                    "and EV.S_EXPOSED=0 " +
                    "and EV.S_SERV_ID="+myCurrentAccountId+") " +
                    "OR (EV.S_EVENT_TYPE=27 " +
                    "and EV.S_DELETED=0) " +
                    "and EV.S_EXPOSED=0 " +
                    "order by EV.S_DATE";
        } else if(myCurrentAccountRole.toLowerCase().contains("w")) {     //ОФИЦИАНТ
            q = "SELECT " +
                    "EV.S_ID, " +
                    "EV.S_DATE, " +
                    "EV.S_EVENT_TYPE, " +
                    "EV.S_EVENT_SOURCE, " +
                    "EV.S_EVENT_HEADER, " +
                    "EV.S_EVENT_CONTENT, " +
                    "EV.S_EVENT_SPOT_ID, " +
                    "EV.S_EXPOSED, " +
                    "EV.S_DELETED, " +
                    "EV.S_SERV_ID " +
                    "FROM " +
                    "s_cafe_events EV " +
                    "LEFT JOIN S_CAFE_ORDERS ORD ON EV.S_SERV_ID=ORD.S_ID " +
                    "WHERE (" +
                    "  EV.S_EVENT_TYPE<>27" +
                    "  AND EV.S_EVENT_TYPE<>13 " +
                    "  AND s_date>=TRUNC(SYSDATE - 1) " +
                    "  AND EV.S_DELETED=0 " +
                    "  AND ORD.S_DATE_CLOSE IS NULL " +
                    "  ) " +
                    " OR (" +
                    "  EV.S_EVENT_TYPE=13 " +
                    "  AND s_date>=TRUNC(SYSDATE - 1) " +
                    "  AND EV.S_DELETED=0 " +
                    "  ) " +
                    " OR (" +
                    "  EV.S_EVENT_TYPE=25 " +
                    "  AND s_date>=TRUNC(SYSDATE - 1) " +
                    "  AND EV.S_DELETED=0 " +
                    "  ) " +
                    "  OR (" +
                    "  EV.S_EVENT_TYPE=27 " +
                    "  AND EV.S_EVENT_SOURCE=2 " +
                    "  AND EV.S_DELETED=0" +
                    "  AND EV.S_SERV_ID=" + myCurrentAccountId +
                    ") " +
                    "ORDER BY EV.S_DATE ";
        } else if(myCurrentAccountRole.toLowerCase().contains("k") || myCurrentAccountRole.toLowerCase().contains("b")) {     //КУХНЯ или БАРМЕН
            q = "SELECT " +
                    "EV.S_ID, " +
                    "EV.S_DATE, " +
                    "EV.S_EVENT_TYPE, " +
                    "EV.S_EVENT_SOURCE, " +
                    "EV.S_EVENT_HEADER, " +
                    "EV.S_EVENT_CONTENT, " +
                    "EV.S_EVENT_SPOT_ID, " +
                    "EV.S_EXPOSED, " +
                    "EV.S_DELETED, " +
                    "EV.S_SERV_ID " +
                    "FROM " +
                    defaultSchema+".s_cafe_events EV " +
                    "LEFT JOIN S_CAFE_ORDERS ORD ON EV.S_SERV_ID=ORD.S_ID " +
                    "WHERE "+
//                    " OR " +
                    "(" +
                    "  EV.S_EVENT_TYPE in (11) " +
                    "  AND s_date>=TRUNC(SYSDATE - 1) " +
                    "  AND EV.S_EXPOSED=0 " +
                    "  ) " +
                    "  OR (" +
                    "  EV.S_EVENT_TYPE=27 " +
                    "  AND EV.S_EVENT_SOURCE=2 " +
                    "  AND EV.S_EXPOSED=0 " +
                    "  AND EV.S_SERV_ID=" + myCurrentAccountId +
                    ") " +
                    "ORDER BY EV.S_DATE ";
        }
//        else if(myCurrentAccountRole.toLowerCase().contains("a")) {}//ADMINISTRATOR
        try {
            iEvents.addAll(getJdbcTemplate().query(q, new RowMapper<InternalEvent>() {
                @Override
                public InternalEvent mapRow(ResultSet r, int i) throws SQLException {
                    return new InternalEvent(
                            r.getInt(1),
                            r.getTimestamp(2),
                            r.getInt(3),
                            r.getInt(4),
                            r.getString(5),
                            r.getString(6),
                            r.getInt(7),
                            r.getInt(8),
                            r.getInt(9),
                            r.getInt(10)
                    );
                }
            }));
            return iEvents;
        } catch (Exception e) {
            System.out.println("Ошибка получения событий: невозможно получить события");
            e.printStackTrace();
            return null;
        }
    }

    public InternalEvent getEventById(int cafeSpotId, int eventId) {
        String q =
            "select EV.S_ID," +
                "EV.S_DATE, " +
                "EV.S_EVENT_TYPE," +
                "EV.S_EVENT_SOURCE," +
                "EV.S_EVENT_HEADER," +
                "EV.S_EVENT_CONTENT," +
                "EV.S_EVENT_SPOT_ID," +
                "EV.S_EXPOSED," +
                "EV.S_DELETED, " +
                "EV.S_SERV_ID " +
            "from "+defaultSchema+".s_cafe_events " +
            "where s_id="+eventId+" and s_spot_id="+cafeSpotId;
        try {
            return (InternalEvent) getJdbcTemplate().query(q, new RowMapper<InternalEvent>() {
                @Override
                public InternalEvent mapRow(ResultSet r, int i) throws SQLException {
                    return new InternalEvent(
                            r.getInt(1),
                            r.getTimestamp(2),
                            r.getInt(3),
                            r.getInt(4),
                            r.getString(5),
                            r.getString(6),
                            r.getInt(7),
                            r.getInt(8),
                            r.getInt(9),
                            r.getInt(10)
                    );
                }
            });
        }catch (Exception e) {
            System.out.println("Ошибка получения события по ID: невозможно получить события");
            e.printStackTrace();
            return null;
        }
    }

    public int exposeEvent(int eventId, String ip) {
        try {
            String q = "update "+defaultSchema+".s_cafe_events set s_exposed=1 where s_id="+eventId+" and " +
            "((s_event_source=1 and s_event_spot_id="+getSpotIdBySpotIpAddress(ip)+") " +
                    "or (s_event_source=2 and s_event_spot_id=0)" +
                    ")";
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteEvent(int eventId, String ip) {
        try {
            String q = "update "+defaultSchema+".s_cafe_events set s_deleted=1 " +
                    "where s_id="+eventId+" and " +
                    "((s_event_source=1 and s_event_spot_id="+getSpotIdBySpotIpAddress(ip)+") " +
                    "or (s_event_source=2 and s_event_spot_id=0)" +
                    ")";
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка пометки события как удаленное: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public int  putEvent(InternalEvent event, int eventSpotId) {
        try {
            String q = "insert into "+defaultSchema+".s_cafe_events (s_date, s_event_type, s_exposed, s_event_source, s_event_header, s_event_content, s_event_spot_id, s_deleted, s_serv_id)" +
                    "values (CURRENT_TIMESTAMP,?,?,?,?,?,?,?,?)";
            getJdbcTemplate().update(q,
                    event.getEventType(),
                    0,
                    event.getEventSourceBelongsTo(),
                    event.getEventHeader(),
                    event.getEventContent(),
                    eventSpotId,
                    0,
                    event.getEventOrderId()
                    );
            return 1;
        } catch (Exception e) {
            System.out.println("Ошибка отправки события на запись в базу: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }

    public Integer getSpotIdBySpotIpAddress(String remoteAddr) {
        try {
            return getJdbcTemplate().queryForInt("select s_cafe_spot_id from "+defaultSchema+".s_cafe_spot_sectors where s_ip=?", remoteAddr);
        } catch (Exception e) {
            System.out.println("Ошибка получения ID сектора по его IP-адресу: ошибка синтаксиса Oracle");
            e.printStackTrace();
            return 0;
        }
    }
}
