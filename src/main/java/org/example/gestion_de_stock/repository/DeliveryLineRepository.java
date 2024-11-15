package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.DeliveryLine;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryLineRepository extends JpaRepository<DeliveryLine,Integer> {
}
