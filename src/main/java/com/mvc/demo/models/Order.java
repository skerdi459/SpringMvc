package com.mvc.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long ID;


    private String title;
    @OneToMany(mappedBy="orders")
    private Set<OrderItem> orderItems;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users users;


    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public Order() {
        super();
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
