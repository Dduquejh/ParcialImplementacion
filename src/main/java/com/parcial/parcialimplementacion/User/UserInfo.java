package com.parcial.parcialimplementacion.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.parcial.parcialimplementacion.Event.Event;
import com.parcial.parcialimplementacion.Ticket.Ticket;
import com.parcial.parcialimplementacion.Portfolio.Portfolio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String name;
    private String email; // Also is the username
    private String password;
    private String rol;

    /*@ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;*/

    @OneToOne(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Portfolio portfolio;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("organizer-event")
    private Set<Event> event;

    @OneToMany(mappedBy = "attendee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("attendee-ticket")
    private Set<Ticket> tickets;
}
