package Entities;

import java.util.Date;

public class Order {
    long OrderId;
    Date orderDate;
    Cart cart;
    User user;
    Status status;

    public Order(long orderId, Date orderDate, Cart cart, User user, Status status) {
        OrderId = orderId;
        this.orderDate = orderDate;
        this.cart = cart;
        this.user = user;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getOrderId() {
        return OrderId;
    }

    public void setOrderId(long orderId) {
        OrderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
