package com.example.demo.controller;

import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping("/{customerId}/{productId}/{qty}")
    public Orders placeOrder(@PathVariable Long customerId ,@PathVariable Long productId ,@PathVariable int qty){

        return service.placeOrder(customerId,productId,qty);
    }


    @GetMapping
    List<Orders> getAllOrders(){
        return service.getAllOrders();
    }

    @GetMapping(
            "/customer/{customerId}"
    )
    public List<Orders>
    getOrdersByCustomer(
            @PathVariable
            Long customerId
    ){

        return service
                .getOrdersByCustomer(
                        customerId
                );

    }

    @GetMapping(
            "/count/{customerId}"
    )
    public Long countOrders(
            @PathVariable
            Long customerId
    ){

        return service
                .countOrders(
                        customerId
                );
    }

    @GetMapping(
            "/bill/{customerId}"
    )
    public Double totalBill(
            @PathVariable
            Long customerId
    ){

        return service
                .totalBill(
                        customerId
                );
    }

    @GetMapping(
            "/revenue"
    )
    public Double totalRevenue(){

        return service
                .totalRevenue();
    }
}
