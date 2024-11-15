package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Order;
import org.example.gestion_de_stock.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
}
