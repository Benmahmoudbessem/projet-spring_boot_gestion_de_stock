package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.OrderLine;
import org.example.gestion_de_stock.entity.StockMovement;
import org.example.gestion_de_stock.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderLine")
public class OrderLineRestController {


    @Autowired
    OrderLineService orderLineService;

    @PostMapping("/save")
    public OrderLine saveOrderLine(@RequestBody OrderLine orderLine){
        return orderLineService.createOrderLine(orderLine);
    }

    @GetMapping("/all")
    public List<OrderLine> getAllOrderLine(){
        return orderLineService.getAllOrderLine();
    }
    @GetMapping("/getone/{id}")
    public OrderLine getoneOrderLine(@PathVariable int id){
        return orderLineService.getOrderLineByID(id);
    }
    @PutMapping("/update/{id}")
    public OrderLine updateOrderLine(@PathVariable int id , @RequestBody OrderLine orderLine ) {
        OrderLine OL1 =orderLineService.getOrderLineByID(id);
        if (OL1 != null) {
            orderLine.setId((long) id);
            return orderLineService.UpdateOrderLine(orderLine);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrderLine(@PathVariable("id") int id){
        try {
            orderLineService.deleteOrderLine(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}
