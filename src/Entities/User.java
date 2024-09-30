package Entities;

public class User {
    String name;
    Address Address;
    String email;
    String password;
    long phone;

    public User(String name, Address address, String email, String password, long phone) {
        this.name = name;
        Address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
