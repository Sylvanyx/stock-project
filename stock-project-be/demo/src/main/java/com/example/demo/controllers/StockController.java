package com.example.demo.controllers;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Stock;
import com.example.demo.repositories.StockRepository;


@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockRepository repository;

    public StockController(StockRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock savedStock = repository.save(stock);
        return ResponseEntity.created(URI.create("/stocks/" + savedStock.getTicker()))
                .body(savedStock);
    }

    @GetMapping("/{ticker}")
    public ResponseEntity<Stock> getByTicker(@PathVariable String ticker) {
        return repository.findByTicker(ticker)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sector/{sector}")
    public ResponseEntity<List<Stock>> getBySector(@PathVariable String sector) {
        return ResponseEntity.ok(repository.findBySector(sector));
    }

}