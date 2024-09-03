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
@Table(name = "portafolio") //dudas de como llamar a la tabla
public class PortafolioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portafolioId;

    @Column()
    @NotBlank(message = "Portafolio description must not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Portafolio description must contain only letters, numbers and spaces")
    @Getter()
    @Setter()
    private String portafolioDescription;

    @OneToOne
    @JoinColumn(name = "modeloId")
    @Getter()
    @Setter()
    private ModeloEntity modelos;
}
