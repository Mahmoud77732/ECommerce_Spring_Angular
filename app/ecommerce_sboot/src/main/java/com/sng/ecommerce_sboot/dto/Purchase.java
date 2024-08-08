/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.dto;

import com.sng.ecommerce_sboot.entity.Address;
import com.sng.ecommerce_sboot.entity.Customer;
import com.sng.ecommerce_sboot.entity.Order;
import com.sng.ecommerce_sboot.entity.OrderItem;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author mahmoud
 */
@Data
public class Purchase {
    
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
    
    
}
