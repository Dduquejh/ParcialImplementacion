package com.parcial.parcialimplementacion.Media.Portfolio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parcial.parcialimplementacion.Portfolio.Portfolio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PortfolioMedia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    private String link;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    @JsonBackReference
    private Portfolio portfolio;
}
