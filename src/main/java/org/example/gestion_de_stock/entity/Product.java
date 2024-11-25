package org.example.gestion_de_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer quantity;
    private Double unitPrice;


    @ManyToOne
    private Category category;

    @ManyToOne
    private Supplier supplier;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<StockMovement> stockMovements;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<LowStockAlert> lowStockAlerts;



}
