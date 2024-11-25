package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.entity.Product;
import org.example.gestion_de_stock.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping("/all")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @GetMapping("/getone/{id}")
    public Order getoneOrder(@PathVariable int id){
        return orderService.getOrderByID(id);
    }
    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable int id , @RequestBody Order order) {
        Order r1 = orderService.getOrderByID(id);
        if (r1 != null) {
            order.setId((long) id);
            return orderService.UpdateOrder(order);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") int id){
        try {
            orderService.deleteOrder(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}



