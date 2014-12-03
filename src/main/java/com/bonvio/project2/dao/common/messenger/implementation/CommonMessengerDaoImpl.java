package com.bonvio.project2.dao.common.messenger.implementation;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import com.bonvio.project2.classes.cafe.waiters.internal.InternalMessage;
import com.bonvio.project2.dao.BaseDao;
import com.bonvio.project2.dao.cafe.events.implementation.CafeEventsDaoImpl;
import com.bonvio.project2.dao.common.messenger.CommonMessengerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 18.08.2014.
 */
public class CommonMessengerDaoImpl extends BaseDao implements CommonMessengerDao {
    @Autowired
    public CommonMessengerDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Autowired
    public CafeEventsDaoImpl eventsDao;

    public int getUserIdByPhoneNumber(String number) {
        String q = "select s_id from "+defaultSchema+".s_users where s_phonenumber=?";
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

    public List<InternalMessage> getMessages(String userNum) {
        try {
            Integer myId = getUserIdByPhoneNumber(userNum);
            List<InternalMessage> mList = new LinkedList<>();
            String q = "select " +
                    "CM.S_ID, " +
                    "UR.S_PHONENUMBER, " +
                    "UR.S_PHONENUMBER, " +
                    "CM.S_MSG_HEADER, " +
                    "CM.S_MSG_BODY, " +
                    "CM.S_DATE, " +
                    "CM.S_MSG_STATUS " +
                    "from " +
                    defaultSchema+".s_cafe_messages CM " +
                    "left join " +
                    defaultSchema+".s_users US " +
                    "on " +
                    "CM.S_SENDER_ID = US.S_ID " +
                    "left join " +
                    defaultSchema+".s_users UR " +
                    "on " +
                    "CM.S_RECEIVER_ID = UR.S_ID " +
                    "where " +
                    "US.S_ID=? or UR.S_ID=? " +
                    "order by CM.S_DATE";
            mList.addAll(getJdbcTemplate().query(q, new RowMapper<InternalMessage>() {
                @Override
                public InternalMessage mapRow(ResultSet r, int i) throws SQLException {
                    return new InternalMessage(
                            r.getInt(1),
                            r.getString(2),
                            r.getString(3),
                            r.getString(4),
                            r.getString(5),
                            r.getTimestamp(6),
                            r.getInt(7)
                    );
                }
            }, myId, myId));
            return mList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<InternalMessage> getMessagesByDateRange(String userNum, Date from, Date till) {
        try {
            Integer myId = getUserIdByPhoneNumber(userNum);
            List<InternalMessage> mList = new LinkedList<>();
            String q =
                    "select " +
                            "CM.S_ID, " +
                            "UR.S_PHONENUMBER, " +
                            "UR.S_PHONENUMBER, " +
                            "CM.S_MSG_HEADER, " +
                            "CM.S_MSG_BODY, " +
                            "CM.S_DATE, " +
                            "CM.S_MSG_STATUS " +
                            "from " +
                            defaultSchema+".s_cafe_messages CM " +
                            "left join " +
                            defaultSchema+".s_users US " +
                            "on " +
                            "CM.S_SENDER_ID = US.S_ID " +
                            "left join " +
                            defaultSchema+".s_users UR " +
                            "on " +
                            "CM.S_RECEIVER_ID = UR.S_ID " +
                            "where " +
                            "(US.S_ID=? and CM.s_del_by_s == 0) or (CM.s_del_by_r == 0 and UR.S_ID=?) and CM.S_DATE between "+from+" and "+ till + " "+
                            "order by CM.S_DATE";
            mList.addAll(getJdbcTemplate().query(q, new RowMapper<InternalMessage>() {
                @Override
                public InternalMessage mapRow(ResultSet r, int i) throws SQLException {
                    return new InternalMessage(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getTimestamp(6), r.getInt(7));
                }
            }, myId, myId));
            return mList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int sendMessage(String userNum, InternalMessage im) {
        try {
            String q =
                "insert into "+defaultSchema+".s_cafe_messages (" +
                    "s_sender_id, " +
                    "s_receiver_id, " +
                    "s_msg_header," +
                    "s_msg_body," +
                    "s_msg_status," +
                    "s_date, " +
                    "s_del_by_s," +
                    "s_del_by_s_date," +
                    "s_del_by_r," +
                    "s_del_by_r_date" +
                ") values (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, 0, null, 0, null)";
            getJdbcTemplate().update(q,
                    getUserIdByPhoneNumber(im.getMessageSenderNumber()),
                    getUserIdByPhoneNumber(im.getMessageRecieverNumber()),
                    im.getMessageHeader(),
                    im.getMessageBody(),
                    0
            );
            eventsDao.putEvent(
                    new InternalEvent(
                            0,
                            null,
                            27,
                            2,
//                            im.getMessageSenderNumber()+" "+im.getMessageHeader(),
                            im.getMessageSenderNumber(),
                            im.getMessageBody(),
                            0,
                            0,
                            0,
                            getUserIdByPhoneNumber(im.getMessageRecieverNumber())
                    ), 0
            );

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteInboxMessage(String userNum, int messageId) {
        try {
            String q = "update "+defaultSchema+".s_cafe_messages set s_del_by_r=1 and s_del_by_r_date=SYSDATE where s_id="+messageId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int deleteOutboxMessage(String userNum, int messageId) {
        try {
            String q = "update "+defaultSchema+".s_cafe_messages set s_del_by_s=1 and s_del_by_s_date=SYSDATE where s_id="+messageId;
            getJdbcTemplate().update(q);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public InternalMessage getMessageById(String userNum, int messageId) {
        try {
            String q =
                    "select " +
                            "CM.S_ID, " +
                            "UR.S_PHONENUMBER, " +
                            "UR.S_PHONENUMBER, " +
                            "CM.S_MSG_HEADER, " +
                            "CM.S_MSG_BODY, " +
                            "CM.S_DATE, " +
                            "CM.S_MSG_STATUS " +
                            "from " +
                            defaultSchema+".s_cafe_messages CM " +
                            "left join " +
                            defaultSchema+".s_users US " +
                            "on " +
                            "CM.S_SENDER_ID = US.S_ID " +
                            "left join " +
                            defaultSchema+".s_users UR " +
                            "on " +
                            "CM.S_RECEIVER_ID = UR.S_ID " +
                            "where " +
                            "CM.S_ID="+messageId;
            return (InternalMessage) getJdbcTemplate().query(q, new RowMapper<InternalMessage>() {
                @Override
                public InternalMessage mapRow(ResultSet r, int i) throws SQLException {
                    return new InternalMessage(
                            r.getInt(1),
                            r.getString(2),
                            r.getString(3),
                            r.getString(4),
                            r.getString(5),
                            r.getTimestamp(6),
                            r.getInt(7)
                    );
                }
            }, userNum);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
