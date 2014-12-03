package com.bonvio.project2.web.rest.common.printing;

import com.bonvio.project2.classes.cafe.clients.PositionWithQuantity;
import com.bonvio.project2.classes.common.printing.MenuPositionForPrinting;
import com.bonvio.project2.classes.common.printing.UnprintedOrder;
import com.bonvio.project2.dao.common.printing.CommonPrintingDao;
import com.bonvio.project2.dao.common.printing.implementation.CommonPrintingDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Arti on 26.09.2014.
 */

@Controller
@RequestMapping("/common/printing")
public class CommonPrintingService {

    @Autowired
    public CommonPrintingDaoImpl dao;

    @RequestMapping(value = "/addToQueue", method = RequestMethod.POST)
    public @ResponseBody int addToQueue(@RequestParam("orderId") int orderId, HttpServletRequest request) {
        return dao.addToQueue(orderId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/checkUnprinted", method = RequestMethod.POST)
    public @ResponseBody LinkedList<UnprintedOrder> checkUnprinted(HttpServletRequest request) {
        LinkedList<UnprintedOrder> result = dao.checkUnprinted(request.getRemoteAddr());
        System.out.println(result);
        return result;
    }

}
