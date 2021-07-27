package com.mvc.demo.services;

import com.mvc.demo.models.OrderItem;
import com.mvc.demo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;

    public List<OrderItem> orderList(){
        return (List<OrderItem>) orderItemRepository.findAll();
    }


    public void save(OrderItem order) {
        orderItemRepository.save(order);
    }
}
