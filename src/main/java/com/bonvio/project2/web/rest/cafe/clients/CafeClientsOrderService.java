package com.bonvio.project2.web.rest.cafe.clients;

import com.bonvio.project2.classes.cafe.events.MenuPositionWithQuantity;
import com.bonvio.project2.dao.cafe.clients.implementation.CafeClientsOrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Arti on 19.06.2014.
 */

@Controller
//@RequestMapping("cafe/order")
@RequestMapping("app_libclients/order")
public class CafeClientsOrderService {

    @Autowired
    public CafeClientsOrderDaoImpl dao;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody int addOrder(@RequestBody String order, HttpServletRequest request) {
        return dao.addOrder(order, new Date(), request);
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public @ResponseBody ArrayList<MenuPositionWithQuantity> getPositionsWithStatus(@RequestParam("orderId") int orderId) {
        return dao.getPositionsWithStatus(orderId);
    }

    @RequestMapping(value = "/closeOrder", method = RequestMethod.POST)
//    public @ResponseBody int closeOrder(@RequestHeader(value = "tblNum", required = true) int tblNum, @RequestHeader(value = "orderId", required = true) int orderId, HttpServletRequest request) {
    public @ResponseBody int closeOrder(@RequestParam(value = "tblNum", required = true) int tblNum, @RequestParam(value = "orderId", required = true) int orderId, HttpServletRequest request) {
        return dao.closeOrder(tblNum, orderId, request.getRemoteAddr());
    }
}
