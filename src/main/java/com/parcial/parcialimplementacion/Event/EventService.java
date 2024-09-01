package com.parcial.parcialimplementacion.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService{
    @Autowired
    private IEventDAO eventDAO;

    @Override
    public List<Event> findAll(){
        return eventDAO.findAll();
    }

    @Override
    public Event save(Event event){
        return eventDAO.save(event);
    }

    @Override
    public Event findById(Long id){
        return eventDAO.findById(id).orElse(null);
    }

    @Override
    public void deletedById(Long id){
        eventDAO.deleteById(id);
    }
}
