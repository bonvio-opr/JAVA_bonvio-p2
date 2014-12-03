package com.bonvio.project2.web.rest.cafe.kitchen;

import com.bonvio.project2.classes.cafe.kitchen.MenuPositionWithRecipe;
import com.bonvio.project2.classes.cafe.waiters.internal.OrderForWaiter;
import com.bonvio.project2.dao.cafe.kitchen.implementation.CafeKitchenOrdersDaoImpl;
import com.bonvio.project2.dao.cafe.waiters.implementation.CafeWaitersOrdersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Arti on 30.07.2014.
 */

@RestController
@RequestMapping("/app_libkitchen/orders")
public class CafeKitchenOrdersService {

    @Autowired(required = true)
    public CafeKitchenOrdersDaoImpl dao;

    @RequestMapping(value = "/getOrders", method = RequestMethod.POST)
    public List<OrderForWaiter> getOrdersForWaiters() { //XXXX: add internal selection by spot ID or by waiter ID (later will be implemented in ADMINISTRATION unit)
        return dao.getOrders();
    }

    @RequestMapping(value = "/getOrderById", method = RequestMethod.POST)
    public OrderForWaiter getOrderById(@RequestParam("orderId") int orderId) {
        return dao.getOrderByOrderId(orderId);
    }

    /*@RequestMapping(value = "/getMenuPositionWithRecipe", method = RequestMethod.POST)
    public MenuPositionWithRecipe getMenuPositionWithRecipe(@RequestParam("positionId") int positionId) {
        return dao.getMenuPositionById(positionId);
    }*/

    @RequestMapping(value = "/statusSetAccepted", method = RequestMethod.POST)
    public int statusSetAccepted(@RequestParam("orderId") int orderId, @RequestParam("positionId") int positionId) {
        return dao.statusSetAccepted(orderId, positionId);
    }

    @RequestMapping(value = "/statusSetRejected", method = RequestMethod.POST)
    public int statusSetRejected(@RequestParam("orderId") int orderId, @RequestParam("positionId") int positionId) {
        return dao.statusSetRejected(orderId, positionId);
    }

    @RequestMapping(value = "/statusSetReady", method = RequestMethod.POST)
    public int statusSetReady(@RequestParam("orderId") int orderId, @RequestParam("positionId") int positionId) {
        return dao.statusSetReady(orderId, positionId);
    }

}
