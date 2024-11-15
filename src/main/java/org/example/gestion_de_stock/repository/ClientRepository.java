package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
