package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
