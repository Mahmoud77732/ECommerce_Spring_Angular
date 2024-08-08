/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.controller;

import com.sng.ecommerce_sboot.dto.Purchase;
import com.sng.ecommerce_sboot.dto.PurchaseResponse;
import com.sng.ecommerce_sboot.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mahmoud
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    
    private CheckoutService checkoutService;
    
    @Autowired // optional because ther is one constructor
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }
    
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
    
}
