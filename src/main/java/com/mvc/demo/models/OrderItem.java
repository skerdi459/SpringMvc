package com.mvc.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
   @Id
   private Long ID;
   private String name_item;
   private int quanty;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order orders;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public OrderItem(Long ID, Order orders) {
        this.ID = ID;
        this.orders = orders;
    }

    public OrderItem() {
       super();
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getName_item() {
        return name_item;
    }

    public void setName_item(String name_item) {
        this.name_item = name_item;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }


}
