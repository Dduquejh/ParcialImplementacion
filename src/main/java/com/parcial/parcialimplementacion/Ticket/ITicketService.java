package com.parcial.parcialimplementacion.Ticket;

import com.parcial.parcialimplementacion.Event.Event;
import com.parcial.parcialimplementacion.User.UserInfo;
import java.util.List;

public interface ITicketService {
    public Ticket save(Ticket ticket);
    public void deleteById(Long id);
    public TicketDTO findById(Long id);
    public Ticket findTicketById(Long id);
    public List<Ticket> findAllTickets();
    public List<TicketDTO> findAll();
}
