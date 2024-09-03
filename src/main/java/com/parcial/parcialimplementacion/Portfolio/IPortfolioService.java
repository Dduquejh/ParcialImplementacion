package com.parcial.parcialimplementacion.Portfolio;

import java.util.List;

public interface IPortfolioService {
    public Portfolio save(Portfolio portfolio);
    public void deleteById(Long id);
    public Portfolio findById(Long id);
    public List<Portfolio> findAll();
}
