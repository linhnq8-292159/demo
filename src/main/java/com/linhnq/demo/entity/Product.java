package com.linhnq.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 250)
    private String productName;
    private int year;
    private Double price;
    private String url;

    public Product(String productName, int year, Double price, String url) {
        this.productName = productName;
        this.year = year;
        this.price = price;
        this.url = url;
    }
}
