package org.example.gestion_de_stock.service;

import org.example.gestion_de_stock.entity.Invoice;
import org.example.gestion_de_stock.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {return invoiceRepository.save(invoice);}
    public List<Invoice> getAllInvoice() { return invoiceRepository.findAll();}
    public Invoice getInvoiceByID(int id){return invoiceRepository.findById(id).orElse(null);}
    public Invoice UpdateInvoice(Invoice invoice){return invoiceRepository.saveAndFlush(invoice);}
    public void deleteInvoice(int id){ invoiceRepository.deleteById(id);}
}
