package com.parcial.parcialimplementacion.Media.Event;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parcial.parcialimplementacion.Media.Media;
import com.parcial.parcialimplementacion.Event.Event;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("EVENT")
@Getter
@Setter
public class EventMedia extends Media{
    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private Event event;
}
