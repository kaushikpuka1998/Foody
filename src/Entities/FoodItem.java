package Entities;

public class FoodItem {
    String name;
    String description;
    double rating;
    int price;

    public FoodItem(String name, String description, double rating, int price) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
