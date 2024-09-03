package com.parcial.parcialimplementacion.Media.Event;

import com.parcial.parcialimplementacion.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/events/{eventId}/media")
public class EventMediaController {
    @Autowired
    private EventMediaService eventMediaService;

    @Autowired
    private EventService eventService;

    @GetMapping()
    public ResponseEntity<?> getAllEventMedia(@PathVariable Long eventId){
        if (eventService.findById(eventId) == null)
            return ResponseEntity.status(404).body("Event not found");
        List<EventMedia> eventMedia = eventMediaService.findAllByEventId(eventId);
        if (eventMedia == null)
            return ResponseEntity.status(404).body("Event not found");
        return ResponseEntity.status(200).body(eventMedia);
    }

    @PostMapping()
    public ResponseEntity<?> postEventMedia(@PathVariable Long eventId, @RequestBody EventMedia eventMedia){
        if (eventService.findById(eventId) == null)
            return ResponseEntity.status(404).body("Event not found");
        try{
            eventMediaService.save(eventId, eventMedia);
            return ResponseEntity.status(201).body(eventMedia);
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/{mediaId}")
    public ResponseEntity<?> deleteEventMedia(@PathVariable Long eventId, @PathVariable Long mediaId){
        if (eventService.findById(eventId) == null)
            return ResponseEntity.status(404).body("Event not found");
        try{
            eventMediaService.deletedMediaFromEvent(eventId, mediaId);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
