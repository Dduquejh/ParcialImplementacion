package com.parcial.parcialimplementacion.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "models") //dudas de como llamar a la tabla

public class ModeloEntity implements Serializable {
    @Id
    @Getter()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Modelo_id;

    @Column()
    @Getter()
    @Setter()
    private String Modelo_name;

    @Column()
    @Getter()
    @Setter()
    private String Modelo_description;

    //faltaria la relacion con la tabla de la base de datos


}
