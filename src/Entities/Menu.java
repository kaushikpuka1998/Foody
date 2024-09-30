package Entities;

import java.util.List;

public class Menu {
    List<FoodItem> foods;



    public Menu(List<FoodItem> foods) {
        this.foods = foods;
    }

    public void setFoods(List<FoodItem> foods) {
        this.foods = foods;
    }

    public List<FoodItem> getFoods() {
        return foods;
    }
}
