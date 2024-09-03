package com.parcial.parcialimplementacion.Event;

import java.util.List;

public interface IEventService {
    public List<Event> findAll();
    public Event save(Event event);
    public Event findById(Long id);
    public void deletedById(Long id);
}
