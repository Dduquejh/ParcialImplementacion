package com.parcial.parcialimplementacion.Event;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.parcial.parcialimplementacion.Media.Event.EventMedia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    @Future(message = "The event date must be in the future")
    private LocalDate date;

    @Column(name = "place")
    private String place;

    @Column(name = "price")
    private double price;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<EventMedia> media;
}
