package com.parcial.parcialimplementacion.Portfolio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {
    @Autowired
    private IPortfolioService portfolioService;

    @PostMapping()
    public ResponseEntity<?> postPortfolio(@RequestBody Portfolio portfolio) {
        try {
            portfolioService.save(portfolio);
            return ResponseEntity.status(201).body(portfolio);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping()
    public List<Portfolio> getPortfolios() {
        return portfolioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPortfolioById(@PathVariable Long id) {
        Portfolio portfolio = portfolioService.findById(id);
        if (portfolio == null) {
            return ResponseEntity.status(404).body("Portfolio not found");
        }
        return ResponseEntity.status(200).body(portfolio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable Long id) {
        if (portfolioService.findById(id) == null)
            return ResponseEntity.status(404).body("Portfolio not found");
        try {
            portfolioService.deleteById(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePortfolio(@Valid @RequestBody Portfolio portfolio, @PathVariable Long id){
        Portfolio portfolioDB = portfolioService.findById(id);
        if (portfolioDB == null)
            return ResponseEntity.status(404).body("Portfolio not found");
        try{
            portfolioDB.setPortfolioDescription(portfolio.getPortfolioDescription());
            portfolioDB.setModel(portfolio.getModel());
            portfolioService.save(portfolioDB);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
}