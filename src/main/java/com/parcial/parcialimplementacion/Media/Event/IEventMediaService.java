package com.parcial.parcialimplementacion.Media.Event;

import java.util.List;

public interface IEventMediaService {
    public List<EventMedia> findAllByEventId(Long eventId);
    public EventMedia save(Long eventId, EventMedia eventMedia);
    public void deletedMediaFromEvent(Long eventId, Long mediaId);
}
