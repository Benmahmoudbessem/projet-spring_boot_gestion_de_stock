package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.OrderLine;
import org.example.gestion_de_stock.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {
    @Autowired
    OrderLineRepository orderLineRepository;

    public OrderLine createOrderLine(OrderLine orderLine) {return orderLineRepository.save(orderLine);}
    public List<OrderLine> getAllOrderLine() { return orderLineRepository.findAll();}
    public OrderLine getOrderLineByID(int id){return orderLineRepository.findById(id).orElse(null);}
    public OrderLine UpdateOrderLine(OrderLine orderLine){return orderLineRepository.saveAndFlush(orderLine);}
    public void deleteOrderLine(int id){ orderLineRepository.deleteById(id);}
}
