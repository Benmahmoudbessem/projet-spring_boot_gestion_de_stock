package org.example.gestion_de_stock.repository;

import org.example.gestion_de_stock.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
