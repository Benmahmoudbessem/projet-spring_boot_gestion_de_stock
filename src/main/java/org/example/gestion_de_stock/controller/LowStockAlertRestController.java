package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.LowStockAlert;
import org.example.gestion_de_stock.entity.StockMovement;
import org.example.gestion_de_stock.service.LowStockAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lowStock")

public class LowStockAlertRestController {


    @Autowired
    LowStockAlertService lowStockAlertService;

    @PostMapping("/save")
    public LowStockAlert saveLowStockAlert(@RequestBody LowStockAlert lowStockAlert){
        return lowStockAlertService.createLowStockAlert(lowStockAlert);
    }

    @GetMapping("/all")
    public List<LowStockAlert> getAllLowStockAlert(){
        return lowStockAlertService.getAllLowStockAlert();
    }
    @GetMapping("/getone/{id}")
    public LowStockAlert getoneLowStockAlert(@PathVariable int id){
        return lowStockAlertService.getLowStockAlertByID(id);
    }
    @PutMapping("/update/{id}")
    public LowStockAlert updateLowStockAlert(@PathVariable int id , @RequestBody LowStockAlert lowStockAlert ) {
        LowStockAlert LS1 =lowStockAlertService.getLowStockAlertByID(id);
        if (LS1 != null) {
            lowStockAlert.setId((long) id);
            return lowStockAlertService.UpdateLowStockAlert(lowStockAlert);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteLowStockAlert(@PathVariable("id") int id){
        try {
            lowStockAlertService.deleteLowStockAlert(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}
