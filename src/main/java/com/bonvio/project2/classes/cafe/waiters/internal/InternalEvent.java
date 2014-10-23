package com.bonvio.project2.classes.cafe.waiters.internal;

import com.bonvio.project2.classes.cafe.waiters.internal.serializers.InternalEventSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.json.simple.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Arti on 28.07.14.
 */
@JsonSerialize(using = InternalEventSerializer.class)
public class InternalEvent {
    private int eventId ;
    private Timestamp eventTimestamp;
    private int eventType;
    private int eventSourceBelongsTo;
    private String eventHeader;
    private String eventContent;
    private int eventSpotId;
    private int eventIsExposed;
    private int eventIsDeleted;
    private int eventOrderId;

    @Override
    public String toString() {
        return "InternalEvent{" +
                "eventId=" + eventId +
                ", eventTimestamp=" + eventTimestamp +
                ", eventType=" + eventType +
                ", eventSourceBelongsTo=" + eventSourceBelongsTo +
                ", eventHeader='" + eventHeader + '\'' +
                ", eventContent='" + eventContent + '\'' +
                ", eventSpotId=" + eventSpotId +
                ", eventIsExposed=" + eventIsExposed +
                ", eventIsDeleted=" + eventIsDeleted +
                ", eventOrderId=" + eventOrderId +
                '}';
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Timestamp getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Timestamp eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getEventSourceBelongsTo() {
        return eventSourceBelongsTo;
    }

    public void setEventSourceBelongsTo(int eventSourceBelongsTo) {
        this.eventSourceBelongsTo = eventSourceBelongsTo;
    }

    public String getEventHeader() {
        return eventHeader;
    }

    public void setEventHeader(String eventHeader) {
        this.eventHeader = eventHeader;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public int getEventSpotId() {
        return eventSpotId;
    }

    public void setEventSpotId(int eventSpotId) {
        this.eventSpotId = eventSpotId;
    }

    public int getEventIsExposed() {
        return eventIsExposed;
    }

    public void setEventIsExposed(int eventIsExposed) {
        this.eventIsExposed = eventIsExposed;
    }

    public int getEventIsDeleted() {
        return eventIsDeleted;
    }

    public void setEventIsDeleted(int eventIsDeleted) {
        this.eventIsDeleted = eventIsDeleted;
    }

    public int getEventOrderId() {
        return eventOrderId;
    }

    public void setEventOrderId(int eventOrderId) {
        this.eventOrderId = eventOrderId;
    }

    public InternalEvent() {

    }

    public InternalEvent(int eventId, Timestamp eventTimestamp, int eventType, int eventSourceBelongsTo, String eventHeader, String eventContent, int eventSpotId, int eventIsExposed, int eventIsDeleted, int eventOrderId) {

        this.eventId = eventId;
        this.eventTimestamp = eventTimestamp;
        this.eventType = eventType;
        this.eventSourceBelongsTo = eventSourceBelongsTo;
        this.eventHeader = eventHeader;
        this.eventContent = eventContent;
        this.eventSpotId = eventSpotId;
        this.eventIsExposed = eventIsExposed;
        this.eventIsDeleted = eventIsDeleted;
        this.eventOrderId = eventOrderId;
    }
}
