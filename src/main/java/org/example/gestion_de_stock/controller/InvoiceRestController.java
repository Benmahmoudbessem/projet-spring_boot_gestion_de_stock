package org.example.gestion_de_stock.controller;

import org.example.gestion_de_stock.entity.Delivery;
import org.example.gestion_de_stock.entity.Invoice;
import org.example.gestion_de_stock.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("invoice")


public class InvoiceRestController {
    @Autowired
    InvoiceService  invoiceService;

    @PostMapping("/save")
    public Invoice saveInvoice(@RequestBody Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping("/all")
    public List<Invoice> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }
    @GetMapping("/getone/{id}")
    public Invoice getoneInvoice(@PathVariable int id){
        return invoiceService.getInvoiceByID(id);
    }
    @PutMapping("/update/{id}")
    public Invoice updateInvoice(@PathVariable int id , @RequestBody Invoice invoice) {
        Invoice I1 = invoiceService.getInvoiceByID(id);
        if (I1 != null) {
            invoice.setId((long) id);
            return invoiceService.UpdateInvoice(invoice);
        } else {
            throw new RuntimeException("failed!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteInvoice(@PathVariable("id") int id){
        try {
            invoiceService.deleteInvoice(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

}
