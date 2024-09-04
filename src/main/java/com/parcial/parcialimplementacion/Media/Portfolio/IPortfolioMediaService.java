package com.parcial.parcialimplementacion.Media.Portfolio;

import java.util.List;

public interface IPortfolioMediaService {
    public List<PortfolioMedia> findAllByPortfolioId(Long portfolioId);
    public PortfolioMedia save(Long portfolioId, PortfolioMedia portfolioMedia);
    public void deletedMediaFromPortfolio(Long portfolioId, Long mediaId);
}
