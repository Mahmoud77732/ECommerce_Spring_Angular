/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.service;

import com.sng.ecommerce_sboot.dao.CustomerRepository;
import com.sng.ecommerce_sboot.dto.Purchase;
import com.sng.ecommerce_sboot.dto.PurchaseResponse;
import com.sng.ecommerce_sboot.entity.Customer;
import com.sng.ecommerce_sboot.entity.Order;
import com.sng.ecommerce_sboot.entity.OrderItem;
import jakarta.transaction.Transactional;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mahmoud
 */
@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired // @Autowired is optional since we only have one constructor
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();
        
        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        
        // populate order with orderitems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        
        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setBillingAddress(purchase.getBillingAddress());
        
        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);
        
        // save to the database
        customerRepository.save(customer);
        
        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }
    
    private String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }
    
}
