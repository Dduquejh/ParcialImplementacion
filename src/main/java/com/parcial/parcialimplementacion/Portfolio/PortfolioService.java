package com.parcial.parcialimplementacion.Portfolio;

import com.parcial.parcialimplementacion.Model.IModelDAO;
import com.parcial.parcialimplementacion.Model.Model;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

@Service
public class PortfolioService implements IPortfolioService {
    @Autowired
    private IPortfolioDAO portfolioDAO;
    @Autowired
    private IModelDAO modelDAO;

    @Override
    public List<Portfolio> findAll() {
        return portfolioDAO.findAll();
    }

    @Transactional
    @Override
    public Portfolio save(@Valid Portfolio portfolio) {

        if (portfolio.getModel() == null) {
            throw new IllegalArgumentException("model is required");
        }

        if (portfolio.getModel().getModelId() == null || modelDAO.findById(portfolio.getModel().getModelId()).isEmpty()) {
            throw new IllegalArgumentException("model with ID " + portfolio.getModel().getModelId() + " does not exist");
        }

        // Optionally, log the details of the portfolio and models
        System.out.println("Saving portfolio: " + portfolio);
        System.out.println("model ID: " + portfolio.getModel().getModelId());

        return portfolioDAO.save(portfolio);
    }


    @Override
    public Portfolio findById(Long id) {
        return portfolioDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Portfolio portfolio = portfolioDAO.findById(id).orElse(null);

        if (portfolio == null) {
            throw new IllegalArgumentException("Portfolio with ID " + id + " does not exist");
        }


        Model model = portfolio.getModel();
        if (model != null) {
            portfolioDAO.detachModelFromPortfolio(id);
        }

        portfolioDAO.deleteById(id);
    }
}
