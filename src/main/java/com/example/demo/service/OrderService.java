package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerRepository custRepo;

    @Autowired
    private ProductRepository productRepo;

    public Orders placeOrder(Long custId , Long ProdId , int qty){

        Customer customer =
                custRepo.findById(custId)
                        .orElse(null);

        if(customer != null){

            Product product =
                    productRepo.findById(ProdId)
                            .orElse(null);

            if(product != null){

                // check stock
                if(product.getQuantity() < qty){
                    return null;
                }

                Orders order = new Orders();

                order.setCustomer(customer);

                order.setProduct(product);

                order.setQuantityOrdered(qty);

                order.setTotalPrice(
                        product.getPrice()*qty
                );

                // reduce quantity
                product.setQuantity(
                        product.getQuantity()-qty
                );

                // update product table
                productRepo.save(product);

                // save order
                return orderRepo.save(order);
            }
        }

        return null;
    }

    public List<Orders> getAllOrders(){
        return  orderRepo.findAll();
    }

    public List<Orders>
    getOrdersByCustomer(
            Long customerId
    ){
        return orderRepo
                .findByCustomerCustomerId(
                        customerId
                );
    }

    public Long countOrders(
            Long customerId
    ){
        return orderRepo
                .countOrder(
                        customerId
                );
    }

    public Double totalBill(
            Long customerId
    ){
        return orderRepo
                .totalAmount(
                        customerId
                );
    }

    public Double totalRevenue(){

        return orderRepo
                .totalRevenue();
    }


}
