package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.DeliveryLine;
import org.example.gestion_de_stock.repository.DeliveryLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryLineService {
    @Autowired
    DeliveryLineRepository deliveryLineRepository;

    public DeliveryLine createDeliveryLine(DeliveryLine deliveryLine) {return deliveryLineRepository.save(deliveryLine);}
    public List<DeliveryLine> getAllDeliveryLine() { return deliveryLineRepository.findAll();}
    public DeliveryLine getDeliveryLineByID(int id){return deliveryLineRepository.findById(id).orElse(null);}
    public DeliveryLine UpdateDeliveryLine(DeliveryLine deliveryLine){return deliveryLineRepository.saveAndFlush(deliveryLine);}
    public void deleteDeliveryLine(int id){ deliveryLineRepository.deleteById(id);}
}
