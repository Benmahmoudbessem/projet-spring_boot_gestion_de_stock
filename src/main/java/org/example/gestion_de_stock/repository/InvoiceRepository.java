package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
