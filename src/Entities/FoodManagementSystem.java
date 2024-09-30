package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FoodManagementSystem {
    List<Restaurent> restaurents;
    List<Customer> customers;
    HashMap<User, Boolean> users;
    List<Cart> cartList;
    List<Order> orderList;
    HashMap<Address,List<Restaurent>> addressListHashMap;
    HashMap<User,Cart> userCartHashMap;
    HashMap<User,List<Order>> userOrderHashMap;
    public FoodManagementSystem() {
        this.restaurents = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.users = new HashMap<>();
        this.cartList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.addressListHashMap = new HashMap<>();
        this.userCartHashMap = new HashMap<>();
        this.userOrderHashMap = new HashMap<>();
    }

    public void addRestaurent(Restaurent restaurent){
        Address address = restaurent.getAddress();
        restaurents.add(restaurent);
        if (addressListHashMap.containsKey(address)) {
            List<Restaurent> mapList = addressListHashMap.get(address);
            mapList.add(restaurent);
        } else {
            List<Restaurent> mapList = new ArrayList<>();
            mapList.add(restaurent);
            addressListHashMap.put(address, mapList);
        }
    }

    public List<Restaurent> getAllRestaurents() {
        return restaurents;
    }

    public List<Restaurent> getRestaurentByAddress(Address address) {
        return addressListHashMap.get(address);
    }

    public List<FoodItem> getFoodItemsByRestaurent(Restaurent restaurent) {
        return restaurent.getMenu().getFoods();
    }

    public void addToCart(Order order){
        Cart cart = order.getCart();
        cartList.add(cart);
        User user = order.user;
        userCartHashMap.put(user,cart);
    }

    public void removeFromCart(Order order){
        Cart cart = order.getCart();
        cartList.remove(cart);
        User user = order.getUser();
        userCartHashMap.remove(user);
    }

    public void updateCart(Order order){
        Cart cart = order.getCart();
        cartList.remove(cart);
        cartList.add(cart);
        User user = order.getUser();
        userCartHashMap.put(user,cart);
    }

    public void clearCart(User user, Cart cart) {
        List<FoodItemDetails> mutableList = new ArrayList<>(userCartHashMap.get(user).getFoodItemDetails());
        mutableList.clear();
        userCartHashMap.get(user).setFoodItemDetails(mutableList);
    }


    public Cart getCart(User user){
        return userCartHashMap.get(user);
    }

    public void addOrder(Order order){
        orderList.add(order);
        User user = order.getUser();
        if (userOrderHashMap.containsKey(user)) {
            List<Order> mapList = userOrderHashMap.get(user);
            mapList.add(order);
        } else {
            List<Order> mapList = new ArrayList<>();
            mapList.add(order);
            userOrderHashMap.put(user, mapList);
        }
    }



    public double placeOrder(Cart cart, User user){
        if(users.get(user) == null){
            throw new RuntimeException("User not found");

        }else{
            if(!users.get(user)){
                System.out.println("User not logged in");
                return 0;
            }
        }
        double total = 0;
        List<FoodItemDetails> foodItemDetailsList = new ArrayList<>(cart.getFoodItemDetails());
        for (FoodItemDetails foodItemDetails : foodItemDetailsList) {
            total += foodItemDetails.getFoodItem().getPrice() * foodItemDetails.getQuantity();
        }

        List<FoodItemDetails> copiedFoodItemDetailsList = new ArrayList<>();
        for (FoodItemDetails foodItemDetails : foodItemDetailsList) {
            copiedFoodItemDetailsList.add(new FoodItemDetails(
                    foodItemDetails.getFoodItem(),
                    foodItemDetails.getQuantity(),
                    foodItemDetails.getRestaurent()
            ));
        }
        Cart copiedCart = new Cart(cart.getId(), copiedFoodItemDetailsList);
        Order order = new Order(System.currentTimeMillis(), new Date(), copiedCart, user, Status.ORDERED);

        addOrder(order);
        clearCart(user, cart);
        return total;
    }

    public List<Order> getAllOrder(){
        return this.orderList;
    }

    public List<Order> getOrdersByUser(User user){
        return userOrderHashMap.get(user);
    }

    public void registerUser(User user){
        users.put(user,false);
        System.out.println("User Registerd Successfully");
    }

    public void loginUser(User user){
        if(users.get(user) != null){
            users.put(user,true);
            System.out.println("User logged in");
        }else{
            System.out.println("User not found");
        }
    }
    public void logoutUser(User user){
        if(users.get(user) != null){
            users.put(user,false);
            System.out.println("User logged out");
        }else{
            System.out.println("User not found");
        }
    }
}
