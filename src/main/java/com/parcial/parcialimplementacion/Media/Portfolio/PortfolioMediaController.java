package com.parcial.parcialimplementacion.Media.Portfolio;

import com.parcial.parcialimplementacion.Portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/portfolios/{portfolioId}/media")
public class PortfolioMediaController {
    @Autowired
    private PortfolioMediaService portfolioMediaService;

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping()
    public ResponseEntity<?> getAllPortfolioMedia(@PathVariable Long portfolioId) {
        if (portfolioService.findById(portfolioId) == null)
            return ResponseEntity.status(404).body("Portfolio not found");
        List<PortfolioMedia> portfolioMedia = portfolioMediaService.findAllByPortfolioId(portfolioId);
        if (portfolioMedia == null)
            return ResponseEntity.status(404).body("Portfolio not found");
        return ResponseEntity.status(200).body(portfolioMedia);
    }

    @PostMapping()
    public ResponseEntity<?> postPortfolioMedia(@PathVariable Long portfolioId, @RequestBody PortfolioMedia portfolioMedia) {
        if (portfolioService.findById(portfolioId) == null)
            return ResponseEntity.status(404).body("Portfolio not found");
        try {
            portfolioMediaService.save(portfolioId, portfolioMedia);
            return ResponseEntity.status(201).body(portfolioMedia);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/{mediaId}")
    public ResponseEntity<?> deletePortfolioMedia(@PathVariable Long portfolioId, @PathVariable Long mediaId) {
        if (portfolioService.findById(portfolioId) == null)
            return ResponseEntity.status(404).body("Portfolio not found");
        try {
            portfolioMediaService.deletedMediaFromPortfolio(portfolioId, mediaId);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
