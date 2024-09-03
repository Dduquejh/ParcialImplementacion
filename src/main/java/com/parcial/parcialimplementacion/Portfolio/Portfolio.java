package com.parcial.parcialimplementacion.Portfolio;

import com.parcial.parcialimplementacion.Model.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Entity
@Table(name = "portfolio") //dudas de como llamar a la tabla
public class Portfolio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column()
    @NotBlank(message = "portfolio description must not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "portfolio description must contain only letters, numbers and spaces")
    @Getter()
    @Setter()
    private String portfolioDescription;

    @OneToOne
    @JoinColumn(name = "modelId")
    @Getter()
    @Setter()
    private Model model;
}
