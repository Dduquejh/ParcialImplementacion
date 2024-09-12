package com.parcial.parcialimplementacion.Ticket;

import com.parcial.parcialimplementacion.User.UserInfo;
import com.parcial.parcialimplementacion.Event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITicketDAO extends JpaRepository<Ticket, Long> {
}
