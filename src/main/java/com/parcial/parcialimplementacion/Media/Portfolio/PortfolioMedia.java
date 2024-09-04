package com.parcial.parcialimplementacion.Media.Portfolio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parcial.parcialimplementacion.Portfolio.Portfolio;
import com.parcial.parcialimplementacion.Media.Media;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PORTFOLIO")
@Getter
@Setter
public class PortfolioMedia extends Media{
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    @JsonBackReference
    private Portfolio portfolio;
}
