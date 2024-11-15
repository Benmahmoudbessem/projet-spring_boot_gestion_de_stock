package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
}
