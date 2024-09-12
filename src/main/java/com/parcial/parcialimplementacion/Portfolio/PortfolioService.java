package com.parcial.parcialimplementacion.Portfolio;

import com.parcial.parcialimplementacion.User.IUserInfoRepository;
import com.parcial.parcialimplementacion.User.UserInfo;
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
    private IUserInfoRepository modelDAO;

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

        if (portfolio.getModel().getUserID() == null || modelDAO.findById(portfolio.getModel().getUserID()).isEmpty()) {
            throw new IllegalArgumentException("model with ID " + portfolio.getModel().getUserID() + " does not exist");
        }

        // Optionally, log the details of the portfolio and models
        System.out.println("Saving portfolio: " + portfolio);
        System.out.println("model ID: " + portfolio.getModel().getUserID());

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


        UserInfo model = portfolio.getModel();
        if (model != null) {
            portfolioDAO.detachModelFromPortfolio(id);
        }

        portfolioDAO.deleteById(id);
    }
}
