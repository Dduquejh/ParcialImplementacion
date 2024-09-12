package com.parcial.parcialimplementacion.Media.Event;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parcial.parcialimplementacion.Event.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EventMedia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    private String link;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference("event-media")
    private Event event;
}
