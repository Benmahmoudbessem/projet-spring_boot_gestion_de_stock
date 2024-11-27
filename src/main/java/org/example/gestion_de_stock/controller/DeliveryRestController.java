package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Client;
import org.example.gestion_de_stock.entity.Delivery;
import org.example.gestion_de_stock.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("delivery")
public class DeliveryRestController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/save")
    public Delivery saveDelivery(@RequestBody Delivery delivery){
        return deliveryService.createDelivery(delivery);
    }

    @GetMapping("/all")
    public List<Delivery> getAllDelivery(){
        return deliveryService.getAllDelivery();
    }
    @GetMapping("/getone/{id}")
    public Delivery getoneDelivery(@PathVariable int id){
        return deliveryService.getDeliveryByID(id);
    }
    @PutMapping("/update/{id}")
    public Delivery updateDelivery(@PathVariable int id , @RequestBody Delivery delivery) {
        Delivery D1 = deliveryService.getDeliveryByID(id);
        if (D1 != null) {
            delivery.setId((long) id);
            return deliveryService.UpdateDelivery(delivery);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDelivery(@PathVariable("id") int id){
        try {
            deliveryService.deleteDelivery(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}
