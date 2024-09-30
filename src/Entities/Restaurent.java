package Entities;

public class Restaurent {
    String name;
    Address address;
    String Description;
    Menu menu;
    double rating;

    public Restaurent(String name, Address address, String description, Menu menu, double rating) {
        this.name = name;
        this.address = address;
        Description = description;
        this.menu = menu;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void updateRestaurentinfo(){

    }

    public void upDateMenu(Menu menu){

    }
}
