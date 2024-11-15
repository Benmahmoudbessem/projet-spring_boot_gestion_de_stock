package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
