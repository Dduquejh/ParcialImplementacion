package com.parcial.parcialimplementacion.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IPortfolioDAO extends JpaRepository<Portfolio, Long> {
    @Modifying
    @Query("UPDATE Portfolio p SET p.model = null WHERE p.id = :id")
    void detachModelFromPortfolio(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Portfolio p WHERE p.id = :id")
    void deleteById(@Param("id") Long id);
}
