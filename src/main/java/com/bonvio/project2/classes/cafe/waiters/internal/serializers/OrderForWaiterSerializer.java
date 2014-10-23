package com.bonvio.project2.classes.cafe.waiters.internal.serializers;

import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Arti on 06.08.2014.
 */
public class OrderForWaiterSerializer extends JsonSerializer<OrderForWaiter> {
    /*@Override
    public void serialize(OrderForWaiter o, JsonGenerator g, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        g.writeStartObject();
        g.writeNumberField("orderId", o.getOrderId());
        g.writeStringField("orderDateOpened", o.getOrderDateOpened().toString());
        g.writeStringField("orderDateClosed", o.getOrderDateClosed().toString());
        g.writeNumberField("orderTableNumber", o.getOrderTableNumber());
        g.writeNumberField("orderPosId", o.getOrderPosId());
        g.writeStringField("orderPosName", o.getOrderPosName());
        g.writeStringField("orderPosQuant", Double.toString(o.getOrderPosQuant()));
        g.writeEndObject();
    }*/





    @Override
    public void serialize(OrderForWaiter o, JsonGenerator g, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        g.writeStartObject();
        g.writeNumberField("orderId", o.getOrderId());
        try {
            g.writeStringField("orderDateOpened", sdf.format(o.getOrderDateOpened()));
        } catch (Exception e) {
            g.writeStringField("orderDateOpened", "unrecognized date");
        }
        try {
            g.writeStringField("orderDateClosed", sdf.format(o.getOrderDateClosed()));
        } catch (Exception e) {
            g.writeStringField("orderDateClosed", "unrecognized date");
        }
        g.writeNumberField("orderTableNumber", o.getOrderTableNumber());
        g.writeNumberField("orderPosId", o.getOrderPosId());
        g.writeNumberField("orderPosNumber", o.getOrderPosInOrderPosId());
        g.writeNumberField("orderPosStatus", o.getOrderPosStatus());
        g.writeStringField("orderPosName", o.getOrderPosName());
        g.writeStringField("orderPosQuant", Double.toString(o.getOrderPosQuant()));
        g.writeEndObject();
    }
}
