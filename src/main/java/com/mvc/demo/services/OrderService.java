package com.mvc.demo.services;

import com.mvc.demo.models.Order;
import com.mvc.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public Order getOneOrder(Long id) {
        Optional<Order> order=orderRepository.findById(id);
        return  order.get();

    }

    public void deleteOrder(Long id) {
        Optional<Order> order=orderRepository.findById(id);
        order.ifPresent(order1 -> orderRepository.delete(order1));

    }

    public void edit(Order order) {

         Order order1=orderRepository.findById(order.getId()).get();
         order1.setTitle(order.getTitle());
         orderRepository.save(order1);
    }

}
