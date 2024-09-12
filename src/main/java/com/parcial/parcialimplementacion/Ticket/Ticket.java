package com.parcial.parcialimplementacion.Ticket;

import com.parcial.parcialimplementacion.User.UserInfo;
import com.parcial.parcialimplementacion.Event.Event;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference("attendee-ticket")
    private UserInfo attendee;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    @JsonBackReference("event-ticket")
    private Event event;
}
