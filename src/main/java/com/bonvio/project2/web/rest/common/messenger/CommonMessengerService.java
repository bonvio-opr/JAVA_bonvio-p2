package com.bonvio.project2.web.rest.common.messenger;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalMessage;
import com.bonvio.project2.dao.common.messenger.implementation.CommonMessengerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.List;

/**
 * Created by Arti on 18.08.2014.
 */
@RestController
@RequestMapping("/common/messenger")
public class CommonMessengerService {

    @Autowired(required = true)
    public CommonMessengerDaoImpl dao;

    @RequestMapping(value = "/getMessages", method = RequestMethod.POST)
    public List<InternalMessage> getMessages() {
        return dao.getMessages(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("userPhoneNumber").toString());
    }

    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public InternalMessage getMessage(@RequestParam("id") int id) {
        return dao.getMessageById(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("userPhoneNumber").toString(), id);
    }

    @RequestMapping(value = "/getByRange", method = RequestMethod.POST)
    public List<InternalMessage> getMessagesByDateRange(@RequestParam("date1") Date date1, @RequestParam("date2") Date date2) {
        return dao.getMessagesByDateRange(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("userPhoneNumber").toString(), date1, date2);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public int sendMessage(
            @RequestParam("messageSenderNumber") String messageSenderNumber,
            @RequestParam("messageReceiverNumber") String messageReceiverNumber,
            @RequestParam("messageHeader") String messageHeader,
            @RequestParam("messageBody") String messageBody
                           ) {
        return dao.sendMessage(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("userPhoneNumber").toString(), new InternalMessage(
                0,
                messageSenderNumber,
                messageReceiverNumber,
                messageHeader,
                messageBody,
                null,
                0
        ));
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public int delInboxMessage(@RequestParam("id") int id) {
        return dao.deleteInboxMessage(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("userPhoneNumber").toString(), id);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.POST)
    public int delOutboxMessage(@RequestParam("id") int id) {
        return dao.deleteOutboxMessage(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("userPhoneNumber").toString(), id);
    }
}