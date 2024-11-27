package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Client;
import org.example.gestion_de_stock.entity.DeliveryLine;
import org.example.gestion_de_stock.service.DeliveryLineService;
import org.example.gestion_de_stock.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deliveryLine")

public class DeliveryLineRestController {

    @Autowired
    DeliveryService deliveryService;
    @Autowired
    private DeliveryLineService deliveryLineService;

    @PostMapping("/save")
    public DeliveryLine saveDeliveryLine(@RequestBody DeliveryLine deliveryLine){
        return deliveryLineService.createDeliveryLine(deliveryLine);
    }

    @GetMapping("/all")
    public List<DeliveryLine> getAllDeliveryLine(){
        return deliveryLineService.getAllDeliveryLine();
    }
    @GetMapping("/getone/{id}")
    public DeliveryLine getoneDeliveryLine(@PathVariable int id){
        return deliveryLineService.getDeliveryLineByID(id);
    }
    @PutMapping("/update/{id}")
    public DeliveryLine updateDeliveryLine(@PathVariable int id , @RequestBody DeliveryLine deliveryLine) {
        DeliveryLine D1 = deliveryLineService.getDeliveryLineByID(id);
        if (D1 != null) {
            deliveryLine.setId((long) id);
            return deliveryLineService.UpdateDeliveryLine(deliveryLine);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDeliveryLine(@PathVariable("id") int id){
        try {
            deliveryLineService.deleteDeliveryLine(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
