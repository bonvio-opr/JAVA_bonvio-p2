package com.bonvio.project2.classes.cafe.waiters.internal;

import com.bonvio.project2.classes.cafe.waiters.internal.serializers.InternalEventSerializer;
import com.bonvio.project2.classes.cafe.waiters.internal.serializers.InternalMessageSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created by Arti on 28.07.14.
 */
@JsonSerialize(using = InternalMessageSerializer.class)
public class InternalMessage {
    private int messageId;
    private String messageSenderNumber;
    private String messageRecieverNumber ;
    private String messageHeader;
    private String messageBody;
    private Date messageDate;
    private int messageStatus;

    @Override
    public String toString() {
        return "InternalMessage{" +
                "messageId=" + messageId +
                ", messageSenderNumber='" + messageSenderNumber + '\'' +
                ", messageRecieverNumber='" + messageRecieverNumber + '\'' +
                ", messageHeader='" + messageHeader + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", messageDate=" + messageDate +
                ", messageStatus=" + messageStatus +
                '}';
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageSenderNumber() {
        return messageSenderNumber;
    }

    public void setMessageSenderNumber(String messageSenderNumber) {
        this.messageSenderNumber = messageSenderNumber;
    }

    public String getMessageRecieverNumber() {
        return messageRecieverNumber;
    }

    public void setMessageRecieverNumber(String messageRecieverNumber) {
        this.messageRecieverNumber = messageRecieverNumber;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public InternalMessage() {

    }

    public InternalMessage(int messageId, String messageSenderNumber, String messageRecieverNumber, String messageHeader, String messageBody, Date messageDate, int messageStatus) {

        this.messageId = messageId;
        this.messageSenderNumber = messageSenderNumber;
        this.messageRecieverNumber = messageRecieverNumber;
        this.messageHeader = messageHeader;
        this.messageBody = messageBody;
        this.messageDate = messageDate;
        this.messageStatus = messageStatus;
    }
}
