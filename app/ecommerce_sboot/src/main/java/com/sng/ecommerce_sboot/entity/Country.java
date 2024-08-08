/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mahmoud
 */
@Entity
@Table(name="country")
@Getter
@Setter
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="code")
    private String code;
    
    @Column(name="name")
    private String name;
    
    @JsonIgnore // it will ignore the states
    @OneToMany(mappedBy = "country")
    private List<State> states;
    
}
