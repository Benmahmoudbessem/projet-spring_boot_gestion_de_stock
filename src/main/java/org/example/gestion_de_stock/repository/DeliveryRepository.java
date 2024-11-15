package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {
}
