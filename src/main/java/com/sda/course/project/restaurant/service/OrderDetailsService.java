package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.OrderDetails;
import com.sda.course.project.restaurant.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> getALlOrderDetails(){ return orderDetailsRepository.findAll();}
    public void deleteOrderDetailByID(int id) { orderDetailsRepository.deleteById(id);}
    public void createOrderDetails(OrderDetails orderDetails){orderDetailsRepository.save(orderDetails);}
    public void updateOrderDetails(OrderDetails orderDetails){orderDetailsRepository.save(orderDetails);}
}
