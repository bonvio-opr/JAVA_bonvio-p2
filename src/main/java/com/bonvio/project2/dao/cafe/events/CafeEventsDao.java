package com.bonvio.project2.dao.cafe.events;

import com.bonvio.project2.classes.cafe.waiters.internal.InternalEvent;

import java.util.List;

/**
 * Created by Arti on 18.08.2014.
 */
public interface CafeEventsDao {
    public List<InternalEvent> getEvents(int cafeSpotId, String myCurrentAccountRole, Integer myCurrentAccountId, String myCurrentAccountPhoneNumber);
    public InternalEvent getEventById(int cafeSpotId, int eventId);
    public int exposeEvent(int eventSpotId, String ip);
    public int deleteEvent(int eventSpotId, String ip);
    public int putEvent(InternalEvent event, int spotId);
}
