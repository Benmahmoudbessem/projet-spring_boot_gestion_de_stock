package org.example.gestion_de_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class LowStockAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer currentQuantity;
    private LocalDateTime alertDate;


}
