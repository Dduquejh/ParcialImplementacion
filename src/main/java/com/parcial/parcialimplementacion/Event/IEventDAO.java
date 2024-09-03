package com.parcial.parcialimplementacion.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventDAO extends JpaRepository<Event, Long> {
}
