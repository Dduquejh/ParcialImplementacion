package com.parcial.parcialimplementacion.Media.Portfolio;

import com.parcial.parcialimplementacion.Portfolio.Portfolio;
import com.parcial.parcialimplementacion.Portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioMediaService implements IPortfolioMediaService{
    @Autowired
    private IPortfolioMediaDAO portfolioMediaDAO;

    @Autowired
    private PortfolioService portfolioService;

    @Override
    public List<PortfolioMedia>  findAllByPortfolioId(Long portfolioId){
        return portfolioMediaDAO.findByPortfolioId(portfolioId);
    }

    @Override
    public PortfolioMedia save(Long portfolioId, PortfolioMedia portfolioMedia){
        Portfolio portfolio = portfolioService.findById(portfolioId);
        portfolioMedia.setPortfolio(portfolio);
        return portfolioMediaDAO.save(portfolioMedia);
    }

    @Override
    public void deletedMediaFromPortfolio(Long portfolioId, Long mediaId){
        PortfolioMedia portfolioMedia = portfolioMediaDAO.findByPortfolioIdAndMediaId(portfolioId, mediaId);
        portfolioMediaDAO.delete(portfolioMedia);
    }
}
