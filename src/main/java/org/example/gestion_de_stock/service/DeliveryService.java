package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.Delivery;
import org.example.gestion_de_stock.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Delivery createDelivery( Delivery delivery) {return deliveryRepository.save(delivery);}
    public List<Delivery> getAllDelivery() { return deliveryRepository.findAll();}
    public Delivery getDeliveryByID(int id){return deliveryRepository.findById(id).orElse(null);}
    public Delivery UpdateDelivery(Delivery delivery){return deliveryRepository.saveAndFlush(delivery);}
    public void deleteDelivery(int id){ deliveryRepository.deleteById(id);}
}
