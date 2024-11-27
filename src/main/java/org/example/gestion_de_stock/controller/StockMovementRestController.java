package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.StockMovement;
import org.example.gestion_de_stock.entity.Supplier;
import org.example.gestion_de_stock.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stockMovement")

public class StockMovementRestController {


    @Autowired
    StockMovementService stockMovementService;

    @PostMapping("/save")
    public StockMovement saveStockMovement(@RequestBody StockMovement stockMovement){
        return stockMovementService.createStockMovement(stockMovement);
    }

    @GetMapping("/all")
    public List<StockMovement> getAllStockMovement(){
        return stockMovementService.getAllStockMovement();
    }
    @GetMapping("/getone/{id}")
    public StockMovement getoneStockMovement(@PathVariable int id){
        return stockMovementService.getStockMovementByID(id);
    }
    @PutMapping("/update/{id}")
    public StockMovement updateStockMovement(@PathVariable int id , @RequestBody StockMovement stockMovement) {
        StockMovement St1 =stockMovementService.getStockMovementByID(id);
        if (St1 != null) {
            stockMovement.setId((long) id);
            return stockMovementService.UpdateStockMovement(stockMovement);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStockMovement(@PathVariable("id") int id){
        try {
            stockMovementService.deleteStockMovement(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
