package com.bonvio.project2.web.rest.cafe.barman;

import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.dao.cafe.barman.implementation.CafeBarmanOrdersDaoImpl;
import com.bonvio.project2.dao.cafe.waiters.implementation.CafeWaitersOrdersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arti on 30.07.2014.
 */
@RestController
@RequestMapping("/app_libbarman/orders")
public class CafeBarmanOrdersService {

    @Autowired(required = true)
    public CafeBarmanOrdersDaoImpl dao;

    @RequestMapping(value = "/getOrders", method = RequestMethod.POST)
    public List<OrderForWaiter> getOrdersForbarman() { //XXXX: add internal selection by spot ID or by waiter ID (later will be implemented in ADMINISTRATION unit)
        return dao.getOrders();
    }

    @RequestMapping(value = "/getOrderById", method = RequestMethod.POST)
    public LinkedList<OrderForWaiter> getOrderById(@RequestParam("orderId") int orderId) {
        return dao.getOrderByOrderId(orderId);
    }

    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public int closeOrderById(@RequestParam("orderId") int orderId) {
        return dao.closeOrderByOrderId(orderId);
    }

    @RequestMapping(value = "/addPosition", method = RequestMethod.POST)
    public int addPositionToOrder(@RequestParam("orderId") int orderId, @RequestParam("pim") int pim, @RequestParam("newQuant") int newQuant) {
        return dao.addPositionToOrder(orderId, pim, newQuant);
    }

    @RequestMapping(value = "/statusSetAccepted", method = RequestMethod.POST)
    public int statusSetAccepted(@RequestParam("orderId") int orderId, @RequestParam("posId") int positionId, HttpServletRequest request) {
        return dao.statusSetAccepted(orderId, positionId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/statusSetRejected", method = RequestMethod.POST)
    public int statusSetRejected(@RequestParam("orderId") int orderId, @RequestParam("posId") int positionId, HttpServletRequest request) {
        return dao.statusSetRejected(orderId, positionId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/statusSetReady", method = RequestMethod.POST)
    public int statusSetReady(@RequestParam("orderId") int orderId, @RequestParam("posId") int positionId, HttpServletRequest request) {
        return dao.statusSetReady(orderId, positionId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/fastSell", method = RequestMethod.POST)
    public int storeFastSell(@RequestParam("posId") int positionId, @RequestParam("posQuant") int positionQuantity, HttpServletRequest request) {
        return dao.storeFastSell(positionId, positionQuantity, request.getRemoteAddr());
    }
}