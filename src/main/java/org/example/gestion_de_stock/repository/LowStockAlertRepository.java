package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.LowStockAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LowStockAlertRepository extends JpaRepository<LowStockAlert,Integer> {
}
