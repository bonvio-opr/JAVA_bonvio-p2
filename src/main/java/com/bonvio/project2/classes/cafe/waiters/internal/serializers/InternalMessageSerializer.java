package com.bonvio.project2.classes.cafe.waiters.internal.serializers;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalMessage;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Arti on 06.08.2014.
 */
public class InternalMessageSerializer extends JsonSerializer<InternalMessage> {
    @Override
    public void serialize(InternalMessage i, JsonGenerator g, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        g.writeStartObject();
        g.writeNumberField("messageId", i.getMessageId());
        g.writeStringField("messageSenderNumber", i.getMessageSenderNumber());
        g.writeStringField("messageRecieverNumber", i.getMessageRecieverNumber());
        g.writeStringField("messageHeader", i.getMessageHeader());
        g.writeStringField("messageBody", i.getMessageBody());
        try {
            g.writeStringField("messageDate", sdf.format(i.getMessageDate()));
        } catch (Exception e) {
            g.writeStringField("messageDate", "unrecognized date exception");
        }
        g.writeNumberField("messageStatus", i.getMessageStatus());
        g.writeEndObject();
    }
}
