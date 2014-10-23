package com.bonvio.project2.classes.cafe.waiters.internal.serializers;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Arti on 06.08.2014.
 */
public class InternalEventSerializer extends JsonSerializer<InternalEvent> {
    @Override
    public void serialize(InternalEvent i, JsonGenerator g, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        g.writeStartObject();
        g.writeNumberField("eventId", i.getEventId());
        try {
            g.writeStringField("eventTimestamp", sdf.format(i.getEventTimestamp()));
        } catch (Exception e) {
            g.writeStringField("eventDate", "unrecognized timestamp");
        }
        g.writeNumberField("eventType", i.getEventType());
        g.writeNumberField("eventSourceBelongsTo", i.getEventSourceBelongsTo());
        g.writeStringField("eventHeader", i.getEventHeader());
        g.writeStringField("eventContent", i.getEventContent());
        g.writeNumberField("eventSpotId", i.getEventSpotId());
        g.writeNumberField("eventIsExposed", i.getEventIsExposed());
        g.writeNumberField("eventIsDeleted", i.getEventIsDeleted());
        g.writeNumberField("eventOrderId", i.getEventOrderId());
        g.writeEndObject();
    }
}
