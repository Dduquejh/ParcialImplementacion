package com.parcial.parcialimplementacion.Portafolio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.parcial.parcialimplementacion.Modelo.ModeloEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Entity
@Table(name = "portafolios") //dudas de como llamar a la tabla
public class PortafolioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Portafolio_id;

    @Column()
    @NotBlank(message = "Portafolio description must not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Portafolio description must contain only letters, numbers and spaces")
    @Getter()
    @Setter()
    private String Portafolio_description;

    @OneToOne
    @JoinColumn(name = "Modelo_id")
    @NotNull(message = "Model id must not be empty")
    @Getter()
    @Setter()
    private ModeloEntity modelos;
}