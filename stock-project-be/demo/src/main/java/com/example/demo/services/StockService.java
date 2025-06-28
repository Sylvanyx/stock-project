package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.Stock;
import com.example.demo.repositories.StockRepository;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

}