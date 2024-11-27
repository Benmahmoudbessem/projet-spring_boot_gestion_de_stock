package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Invoice;
import org.example.gestion_de_stock.entity.Supplier;
import org.example.gestion_de_stock.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")

public class SupplierRestController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("/save")
    public Supplier saveSupplier(@RequestBody Supplier supplier){
        return supplierService.createSupplier(supplier);
    }

    @GetMapping("/all")
    public List<Supplier> getAllSupplier(){
        return supplierService.getAllSupplier();
    }
    @GetMapping("/getone/{id}")
    public Supplier getoneSupplier(@PathVariable int id){
        return supplierService.getSupplierByID(id);
    }
    @PutMapping("/update/{id}")
    public Supplier updateSupplier(@PathVariable int id , @RequestBody Supplier supplier) {
        Supplier S1 =supplierService.getSupplierByID(id);
        if (S1 != null) {
            supplier.setId((long) id);
            return supplierService.UpdateSupplier(supplier);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSupplier(@PathVariable("id") int id){
        try {
            supplierService.deleteSupplier(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
