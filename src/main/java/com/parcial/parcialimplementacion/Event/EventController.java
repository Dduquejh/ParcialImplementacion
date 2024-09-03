package com.parcial.parcialimplementacion.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping()
    public List<Event> getClients(){
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable Long id){
        Event event = eventService.findById(id);
        if(event == null)
            return ResponseEntity.status(404).body("Event not found");
        return ResponseEntity.status(200).body(event);
    }

    @PostMapping()
    public ResponseEntity<?> postClient(@Valid @RequestBody Event event){
        try{
            eventService.save(event);
            return ResponseEntity.status(201).body(event);
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id){
        if(eventService.findById(id) == null)
            return ResponseEntity.status(404).body("Event not found");
        try{
            eventService.deletedById(id);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@Valid @RequestBody Event event, @PathVariable Long id){
        Event eventDB = eventService.findById(id);
        if(eventDB == null)
            return ResponseEntity.status(404).body("Event not found");
        try{
            eventDB.setName(event.getName());
            eventDB.setDescription(event.getDescription());
            eventDB.setDate(event.getDate());
            eventDB.setPlace(event.getPlace());
            eventDB.setPrice(event.getPrice());
            eventDB.setCapacity(event.getCapacity());
            eventService.save(eventDB);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
