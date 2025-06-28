package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Stock;


public interface StockRepository extends JpaRepository<Stock, String> {
    Optional<Stock> findByTicker(String ticker);

    List<Stock> findBySector(String sector);

    // Add these for better querying:
    List<Stock> findByIndustry(String industry);

    List<Stock> findByCurrency(String currency);

}