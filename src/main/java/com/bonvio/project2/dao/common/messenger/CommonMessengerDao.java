package com.bonvio.project2.dao.common.messenger;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalMessage;

import java.util.Date;
import java.util.List;

/**
 * Created by Arti on 18.08.2014.
 */
public interface CommonMessengerDao {
    public List<InternalMessage> getMessages(String userNum);
    public List<InternalMessage> getMessagesByDateRange(String userNum, Date from,Date till);
    public int sendMessage(String userNum, InternalMessage internalMessage);
    public int deleteInboxMessage(String userNum, int messageId);
    public int deleteOutboxMessage(String userNum, int messageId);
    public InternalMessage getMessageById(String userNum, int messageId);
}
