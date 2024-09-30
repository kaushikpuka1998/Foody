package Entities;

import java.util.List;

public class Cart {
    Long id;
    List<FoodItemDetails> foodItemDetails;
    CartStatus status;

    public Cart(Long id, List<FoodItemDetails> foodItemDetails) {
        this.id = id;
        this.foodItemDetails = foodItemDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLength() {
        return foodItemDetails.size();
    }

    public List<FoodItemDetails> getFoodItemDetails() {
        return foodItemDetails;
    }

    public void setFoodItemDetails(List<FoodItemDetails> foodItemDetails) {
        this.foodItemDetails = foodItemDetails;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }
}
