package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.LowStockAlert;
import org.example.gestion_de_stock.repository.LowStockAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class LowStockAlertService {
    @Autowired
    LowStockAlertRepository lowStockAlertRepository;
@Autowired private ProductService productService;

    public LowStockAlert createLowStockAlert(LowStockAlert lowStockAlert) {return lowStockAlertRepository.save(lowStockAlert);}
    public List<LowStockAlert> getAllLowStockAlert() { return lowStockAlertRepository.findAll();}
    public LowStockAlert getLowStockAlertByID(int id){return lowStockAlertRepository.findById(id).orElse(null);}
    public LowStockAlert UpdateLowStockAlert(LowStockAlert lowStockAlert){return lowStockAlertRepository.saveAndFlush(lowStockAlert);}
    public void deleteLowStockAlert(int id){ lowStockAlertRepository.deleteById(id);}
}
