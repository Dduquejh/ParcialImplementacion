package com.parcial.parcialimplementacion.Media.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPortfolioMediaDAO extends JpaRepository<PortfolioMedia, Long> {
    List<PortfolioMedia> findByPortfolioId(Long id);
    PortfolioMedia findByPortfolioIdAndMediaId(Long portfolioID, Long mediaId);
}
