package com.parcial.parcialimplementacion.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Model name must not be empty")
    @Size(min = 1, message = "Model name must be al least 1 character")
    @Getter()
    @Setter()
    private String Modelo_name;

    @Column()
    @NotBlank(message = "Model description must not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Model description must contain only letters, numbers and spaces")
    @Getter()
    @Setter()
    private String Modelo_description;

    //faltaria la relacion con la tabla de la base de datos


}