package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.Supplier;
import org.example.gestion_de_stock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Supplier createSupplier(Supplier supplier) {return supplierRepository.save(supplier);}
    public List<Supplier> getAllSupplier() { return supplierRepository.findAll();}
    public Supplier getSupplierByID(int id){return supplierRepository.findById(id).orElse(null);}
    public Supplier UpdateSupplier(Supplier supplier){return supplierRepository.saveAndFlush(supplier);}
    public void deleteSupplier(int id){ supplierRepository.deleteById(id);}
}
