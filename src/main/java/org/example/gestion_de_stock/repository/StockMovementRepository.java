package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement,Integer> {
}
