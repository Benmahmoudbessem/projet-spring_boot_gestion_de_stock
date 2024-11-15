package org.example.gestion_de_stock.service;


import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order) {return orderRepository.save(order);}
    public List<Order> getAllOrder() { return orderRepository.findAll();}
    public Order getOrderByID(int id){return orderRepository.findById(id).orElse(null);}
    public Order UpdateOrder(Order order){return orderRepository.saveAndFlush(order);}
    public void deleteOrder(int id){ orderRepository.deleteById(id);}
}
