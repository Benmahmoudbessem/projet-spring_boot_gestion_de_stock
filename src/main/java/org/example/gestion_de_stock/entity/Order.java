package org.example.gestion_de_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "commande")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice", referencedColumnName = "id")
    private Invoice invoice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private Delivery delivery;


}
