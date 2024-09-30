package Entities;

import java.util.List;

public class Customer {
    User user;
    List<Order> orders;
    Cart cart;


    public User updateInfo(User user){
        this.user = user;
        return user;
    }
    public void placeOrder(Order order){
        orders.add(order);
    }
}
