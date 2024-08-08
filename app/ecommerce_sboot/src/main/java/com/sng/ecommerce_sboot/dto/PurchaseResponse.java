/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.dto;

import lombok.Data;

/**
 *
 * @author mahmoud
 */
@Data
public class PurchaseResponse {
    
    // Lombok @Data will generate constructor for final fields
    // instead of "final" you can use @NotNull
    private final String orderTrackingNumber;
    
}
