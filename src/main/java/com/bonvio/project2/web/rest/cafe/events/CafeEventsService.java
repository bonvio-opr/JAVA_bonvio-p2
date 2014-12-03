package com.bonvio.project2.web.rest.cafe.events;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;
import com.bonvio.project2.dao.cafe.events.CafeEventsDao;
import com.bonvio.project2.dao.cafe.events.implementation.CafeEventsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Arti on 18.08.2014.
 */

@RestController
@RequestMapping("/cafe/events")
public class CafeEventsService {
    @Autowired
    private CafeEventsDaoImpl dao;

    @RequestMapping(value = "/getEvents", method = RequestMethod.POST)
    public List<InternalEvent> getEvents(@RequestParam("spotId") int spotId, @RequestParam("myCurrentAccountRole") String myCurrentAccountRole, HttpServletRequest request) {
        if(myCurrentAccountRole.equals("c")) {
            try {
                return dao.getEvents(spotId, myCurrentAccountRole, Integer.parseInt(request.getSession().getAttribute("cafeUserId").toString()), request.getSession().getAttribute("cafeUserPhoneNumber").toString());
            } catch (Exception e) {
                System.out.println("Невозможно получить СОБЫТИЯ ДЛЯ КЛИЕНТА");
                e.printStackTrace();
                return null;
            }
        } else {
            try {
                return dao.getEvents(spotId, myCurrentAccountRole, Integer.parseInt(request.getSession().getAttribute("userId").toString()), request.getSession().getAttribute("userPhoneNumber").toString());
            } catch (Exception e) {
                System.out.println("Невозможно получить СОБЫТИЯ ДЛЯ СОТРУДНИКА");
//                e.printStackTrace();
                return null;
            }
        }
    }

    @RequestMapping(value = "/getEventById", method = RequestMethod.POST)
    public InternalEvent getEventById(@RequestParam("spotId") int spotId, @RequestParam("eventId") int eventId) {
        return dao.getEventById(spotId, eventId);
    }

    @RequestMapping(value = "/exposeById", method = RequestMethod.POST)
    public int exposeEventById(@RequestParam("eventId") int eventId, HttpServletRequest request) {
        return dao.exposeEvent(eventId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public int deleteEventById(@RequestParam("eventId") int eventId, HttpServletRequest request) {
        return dao.deleteEvent(eventId, request.getRemoteAddr());
    }

    @RequestMapping(value = "/putEvent", method = RequestMethod.POST)
    public int putEvent(@RequestParam("event") InternalEvent event, @RequestParam("spotId") int spotId) {
        return dao.putEvent(event, spotId);
    }


}
