/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author mahmoud
 */
@Entity
@Table(name = "product")
@Data // getters / setters
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
    
    @Column(name="sku")
    private String sku;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="unit_price")
    private BigDecimal unitPrice;
    
    @Column(name="image_url")
    private String imageUrl;
    
    @Column(name="active")
    private boolean active;
    
    @Column(name="units_in_stock")
    private int unitsInStock;
    
    @Column(name="date_created")
    @CreationTimestamp // Hibernate will auto manage the timestamps
    private Date dateCreated;
    
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;
    
}
