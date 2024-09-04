package com.parcial.parcialimplementacion.Portfolio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.parcial.parcialimplementacion.Media.Portfolio.PortfolioMedia;
import com.parcial.parcialimplementacion.Model.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "portfolio")
@Getter
@Setter
public class Portfolio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    @NotBlank(message = "portfolio description must not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "portfolio description must contain only letters, numbers and spaces")
    private String portfolioDescription;

    @OneToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<PortfolioMedia> media;
}
