package com.bonvio.project2.web.rest.cafe.waiters;

import com.bonvio.project2.classes.cafe.clients.MenuPosition;
import com.bonvio.project2.classes.cafe.kitchen.MenuPositionWithRecipe;
import com.bonvio.project2.classes.cafe.waiters.FullMenuDBExtractor;
import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.classes.common.menuupload.MenuCategory;
import com.bonvio.project2.dao.cafe.waiters.implementation.CafeWaitersOrdersDaoImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Arti on 10.07.2014.
 */

@RestController
@RequestMapping("/app_libwaiters/orders")
public class CafeWaitersOrdersService {

    @Autowired(required = true)
    public CafeWaitersOrdersDaoImpl dao;

    @RequestMapping(value = "/getOrders", method = RequestMethod.POST)
    public List<OrderForWaiter> getOrdersForWaiters() { //XXXX: add internal selection by spot ID or by waiter ID (later will be implemented in ADMINISTRATION unit)
        return dao.getOrders();
    }

    @RequestMapping(value = "/getOrderById", method = RequestMethod.POST)
    public @ResponseBody List<OrderForWaiter> getOrderById(@RequestParam("orderId") int orderId) {
//    public OrderForWaiter getOrderById(HttpServletRequest request) {
        try {
            return dao.getOrderByOrderId(orderId);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public int closeOrderById(@RequestParam("orderId") int orderId) {
        return dao.closeOrderByOrderId(orderId);
    }

    @RequestMapping(value = "/createAnonymousOrderOnTable", method = RequestMethod.POST)
    public int createAnonymousOrderOnTable(@RequestParam("tableId") int tableId, @RequestParam("serializedOrder") String serializedOrder, HttpServletRequest request) {
        return dao.createAnonymousOrderOnTable(tableId, serializedOrder, request.getRemoteAddr());
    }


    @RequestMapping(value = "/addPosition", method = RequestMethod.POST)
    public int addPositionToOrder(@RequestParam("orderId") int orderId, @RequestParam("pim") int pim, @RequestParam("newQuant") int newQuant) {
        return dao.addPositionToOrder(orderId, pim, newQuant);
    }

    @RequestMapping(value = "/removePositionFromOrder", method = RequestMethod.POST)
    public int removePositionFromOrder(@RequestParam("orderId") int orderId, @RequestParam("pim") int pim, @RequestParam("pio") int pio) {
        return dao.removePositionFromOrder(orderId, pim, pio);
    }

    @RequestMapping(value = "/resizePositionInOrder", method = RequestMethod.POST)
    public int resizePositionInOrder(@RequestParam("orderId") int orderId, @RequestParam("pim") int pim, @RequestParam("pio") int pio, @RequestParam("nst") int newQuant) {
        return dao.resizeOrderPosition(orderId, pim, pio, newQuant);
    }

    @RequestMapping(value = "/setPositionClientRefused", method = RequestMethod.POST)
    public int setPositionClientRefused(@RequestParam("orderId") int orderId, @RequestParam("positionId") int positionId) {
        return dao.statusSetClientRefused(orderId, positionId);
    }

    @RequestMapping(value = "/setPositionReady", method = RequestMethod.POST)
    public int setPositionReady(@RequestParam("orderId") int orderId, @RequestParam("positionId") int positionId) {
        return dao.statusSetReady(orderId, positionId);
    }

    @RequestMapping(value = "/setPositionAccomplished", method = RequestMethod.POST)
    public int setPositionAccomplished(@RequestParam("orderId") int orderId, @RequestParam("orderPosNumber") int positionId, HttpServletRequest request) {
        return dao.statusSetAccomplished(orderId, positionId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
//    public Map<MenuCategory, LinkedList<MenuPosition>> getMenu(HttpServletRequest request) {
    public @ResponseBody LinkedList<FullMenuDBExtractor> getMenu(HttpServletRequest request) {
        return dao.getMenu(request.getRemoteAddr());
    }

    @RequestMapping(value = "/getMenuPositionPicture/{positionId}", method = RequestMethod.GET)
    public int getMenuPositionPicture(@PathVariable("positionId") int positionId, HttpServletResponse response) {
        return dao.getMenuPositionPicture(positionId, response);
    }

}
