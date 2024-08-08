/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mahmoud
 */
@Entity
@Table(name="order_item")
@Getter
@Setter
public class OrderItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long ids;
    
    @Column(name="image_url")
    private String imageUrl;
    
    @Column(name="unit_price")
    private BigDecimal unitPrice;
    
    @Column(name="quantity")
    private int quantity;
    
    @Column(name="product_id")
    private Long productId;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
}
