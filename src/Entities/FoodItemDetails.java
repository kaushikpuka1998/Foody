package Entities;

public class FoodItemDetails {
    FoodItem foodItem;
    int quantity;
    Restaurent restaurent;

    public FoodItemDetails(FoodItem foodItem, int quantity, Restaurent restaurent) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.restaurent = restaurent;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Restaurent getRestaurent() {
        return restaurent;
    }

    public void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }
}
