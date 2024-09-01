package com.parcial.parcialimplementacion.Media.Event;

import com.parcial.parcialimplementacion.Event.Event;
import com.parcial.parcialimplementacion.Event.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMediaService implements IEventMediaService{
    @Autowired
    private IEventMediaDAO eventMediaDAO;

    @Autowired
    private EventService eventService;

    @Override
    public List<EventMedia> findAllByEventId(Long eventId){
        return eventMediaDAO.findByEventId(eventId);
    }

    @Override
    public EventMedia save(Long eventID, EventMedia eventMedia){
        Event event = eventService.findById(eventID);
        eventMedia.setEvent(event);
        return eventMediaDAO.save(eventMedia);
    }

    @Override
    public void deletedMediaFromEvent(Long eventId, Long mediaId){
        EventMedia eventMedia = eventMediaDAO.findByEventIdAndMediaId(eventId, mediaId);
        eventMediaDAO.delete(eventMedia);
    }
}
