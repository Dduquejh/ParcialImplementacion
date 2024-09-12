package com.parcial.parcialimplementacion.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @PostMapping()
    public ResponseEntity<?> postTicket(@RequestBody Ticket ticket) {
        try {
            ticketService.save(ticket);
            return ResponseEntity.status(201).body(ticket);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping()
    public List<TicketDTO> getTickets() {
        return ticketService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable long id) {
        TicketDTO ticket = ticketService.findById(id);
        if (ticket == null) {
            return ResponseEntity.status(404).body("Ticket not found");
        }
        return ResponseEntity.status(200).body(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable long id) {
        if (ticketService.findById(id) == null) {
            return ResponseEntity.status(404).body("Ticket not found");
        }
        try {
            ticketService.deleteById(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTicket(Ticket ticket, @PathVariable long id) {
        Ticket ticketDB = ticketService.findTicketById(id);
        if (ticketDB == null) {
            return ResponseEntity.status(404).body("Ticket not found");
        }
        try {
            ticketDB.setAttendee(ticket.getAttendee());
            ticketDB.setEvent(ticket.getEvent());
            ticketService.save(ticketDB);
            return ResponseEntity.status(200).body(ticketDB);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
