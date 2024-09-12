package com.parcial.parcialimplementacion.Ticket;

import com.parcial.parcialimplementacion.Event.Event;
import com.parcial.parcialimplementacion.Event.IEventDAO;
import com.parcial.parcialimplementacion.User.UserInfo;
import com.parcial.parcialimplementacion.User.IUserInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private ITicketDAO ticketDAO;

    @Autowired
    private IUserInfoRepository attendeeDAO;

    @Autowired
    private IEventDAO eventDAO;

    @Transactional
    @Override
    public Ticket save(@Valid Ticket ticket) {
        if (ticket.getAttendee() == null || attendeeDAO.findById(ticket.getAttendee().getUserID()).isEmpty()) {
            throw new IllegalArgumentException("Attendee is required");
        }
        if (ticket.getEvent() == null || eventDAO.findById(ticket.getEvent().getId()).isEmpty()) {
            throw new IllegalArgumentException("Event is required");
        }

        Event event = eventDAO.findById(ticket.getEvent().getId())
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        if (event.getCapacity() <= 0) {
            throw new IllegalArgumentException("Event is full");
        }

        event.setCapacity(event.getCapacity() - 1);
        eventDAO.save(event);
        return ticketDAO.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        ticketDAO.deleteById(id);
    }

    @Override
    public TicketDTO findById(Long id) {
        Ticket ticket = ticketDAO.findById(id).orElse(null);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found");
        }

        return new TicketDTO(
                ticket.getId(),
                ticket.getAttendee() != null ? ticket.getAttendee().getUserID() : null,
                ticket.getEvent() != null ? ticket.getEvent().getId() : null
        );
    }

    @Override
    public List<TicketDTO> findAll() {
        List<Ticket> tickets = ticketDAO.findAll();
        return tickets.stream().map(ticket ->
                new TicketDTO(
                        ticket.getId(),
                        ticket.getAttendee() != null ? ticket.getAttendee().getUserID() : null,
                        ticket.getEvent() != null ? ticket.getEvent().getId() : null
                )
        ).collect(Collectors.toList());
    }

    @Override
    public Ticket findTicketById(Long id) {
        return ticketDAO.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketDAO.findAll();
    }
}
