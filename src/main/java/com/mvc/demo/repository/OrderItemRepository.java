package com.mvc.demo.repository;

import com.mvc.demo.models.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Long> {

}
