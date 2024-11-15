package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.StockMovement;
import org.example.gestion_de_stock.repository.StockMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMovementService {
    @Autowired
    StockMovementRepository stockMovementRepository;

    public StockMovement createStockMovement( StockMovement stockMovement) {return stockMovementRepository.save(stockMovement);}
    public List<StockMovement> getAllStockMovement() { return stockMovementRepository.findAll();}
    public StockMovement getStockMovementByID(int id){return stockMovementRepository.findById(id).orElse(null);}
    public StockMovement UpdateStockMovement(StockMovement stockMovement){return stockMovementRepository.saveAndFlush(stockMovement);}
    public void deleteStockMovement(int id){ stockMovementRepository.deleteById(id);}
}
