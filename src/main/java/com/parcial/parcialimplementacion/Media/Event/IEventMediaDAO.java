package com.parcial.parcialimplementacion.Media.Event;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEventMediaDAO extends JpaRepository<EventMedia, Long> {
    List <EventMedia> findByEventId(Long id);
    EventMedia findByEventIdAndMediaId(Long eventId, Long mediaId);
}
