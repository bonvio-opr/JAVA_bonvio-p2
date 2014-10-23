package com.bonvio.project2.classes.cafe.clients.extractors.serializers;

import com.bonvio.project2.classes.cafe.clients.CafeObject;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Created by Arti on 30.06.2014.
 */
public class CafeObjectSerializer extends JsonSerializer<CafeObject> {

    @Override
    public void serialize(CafeObject c, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("cafeName", c.getCafeName());
        jsonGenerator.writeStringField("spotName", c.getSpotName());



        jsonGenerator.writeEndObject();
    }
}
