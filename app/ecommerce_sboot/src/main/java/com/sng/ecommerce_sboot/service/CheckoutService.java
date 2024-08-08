/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sng.ecommerce_sboot.service;

import com.sng.ecommerce_sboot.dto.Purchase;
import com.sng.ecommerce_sboot.dto.PurchaseResponse;

/**
 *
 * @author mahmoud
 */
public interface CheckoutService {
    
    PurchaseResponse placeOrder(Purchase purchase);
    
}
