package com.bonvio.project2.classes.cafe.clients.serializers;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Arti on 05.09.2014.
 */
public class MenuPositionSerializer extends JsonSerializer<MenuPosition> {
    @Override
    public void serialize(MenuPosition i, JsonGenerator g, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        g.writeStartObject();

        g.writeNumberField("positionId", i.getPositionId());
        g.writeStringField("positionLanguage", i.getPositionLanguage());
        g.writeStringField("positionName", i.getPositionName());
        g.writeNumberField("positionPrice", i.getPositionPrice());
        g.writeStringField("positionDescription", i.getPositionDescription());
        g.writeNumberField("positionQuantity", i.getPositionQuantity());
        g.writeStringField("positionUnits", i.getPositionUnits());
        g.writeStringField("positionRecipeDescription", i.getPositionRecipeDescription());
        g.writeNumberField("positionStatus", i.getPositionStatus());
        g.writeNumberField("positionIncluded", i.getPositionIncluded());
        g.writeNumberField("positionCategoryType", i.getPositionCategoryType());

        g.writeEndObject();
    }
}
