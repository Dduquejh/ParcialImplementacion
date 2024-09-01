package com.parcial.parcialimplementacion.Media;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="media")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "media_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    private String link;
}
