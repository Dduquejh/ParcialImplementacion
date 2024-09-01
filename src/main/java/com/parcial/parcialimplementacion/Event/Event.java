package com.parcial.parcialimplementacion.Event;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

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
}
