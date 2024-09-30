import Entities.*;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FoodManagementSystem foody = new FoodManagementSystem();


        Address a1 = new Address("Bengaluru", 560037, 12.9716, 77.5946);
        FoodItem vegManchurian = new FoodItem("Veg Manchurian", "Veg Manchurian", 4.5f, 150);
        FoodItem aloo_parathas = new FoodItem("Aloo Parathas", "Aloo Parathas", 4.5f, 75);
        Menu m1 = new Menu(List.of(vegManchurian, aloo_parathas));

        FoodItem vegBiryani = new FoodItem("Veg Biryani", "Veg Biryani", 4.5f, 150);
        FoodItem chickenBiryani = new FoodItem("Chicken Biryani", "Chicken Biryani", 4.5f, 180);
        Menu m2 = new Menu(List.of(vegBiryani, chickenBiryani));

        Restaurent r1 = new Restaurent("KFC", a1, "Best food in town", m1,4.3);
        Restaurent r2 = new Restaurent("McDonalds", a1, "Best NongVeg Vegfood in town", m2,4.1);
        foody.addRestaurent(r1);
        foody.addRestaurent(r2);

//        foody.getAllRestaurents().stream()
//                .flatMap(restaurent -> restaurent.getMenu().getFoods().stream())
//                .map(foodItem -> foodItem.getName())
//                .forEach(System.out::println);

        List<Restaurent> getRestaurent = foody.getRestaurentByAddress(a1);
        System.out.println("=====All Restaurents=========");
        for (Restaurent restaurent : getRestaurent) {
            System.out.println(restaurent.getName());
        }
        System.out.println("=====All Food Items by Restaurent R1=========");
        List<FoodItem> getFoodItems = foody.getFoodItemsByRestaurent(r1);
        getFoodItems.stream()
                .map(foodItem -> foodItem.getName()+" - "+(double)foodItem.getPrice())
                .forEach(System.out::println);

        User u1 =new User("Kaushik Ghosh", a1,"kgstrivers@gmail.com", "1234", 1234567890);
        foody.registerUser(u1);
        foody.loginUser(u1);
        //foody.logoutUser(u1);
        FoodItemDetails foodItemDetails = new FoodItemDetails(vegManchurian, 2, r1);
        Cart c1 = new Cart(1L, List.of(foodItemDetails));

        foody.addToCart(new Order(1L, new Date(), c1, u1, Status.ORDERED));

        //Get a User Cart
        System.out.println("=======Get a User u1 Cart=========");
        Cart userCart = foody.getCart(u1);
        userCart.getFoodItemDetails().stream()
                .map(foodItemDetails1 -> foodItemDetails1.getFoodItem().getName()+"- "+foodItemDetails1.getQuantity())
                .forEach(System.out::println);

        //Place Order
        double total = foody.placeOrder(c1,u1);
        System.out.println("Total: "+total);
        System.out.println("Order Placed");

        //Get a User Cart
        Cart checkcart = foody.getCart(u1);
        if (checkcart.getLength() > 0) {
            checkcart.getFoodItemDetails().stream()
                    .map(foodItemDetails1 -> foodItemDetails1.getFoodItem().getName() + "- " + foodItemDetails1.getQuantity())
                    .forEach(System.out::println);
        }else{
            System.out.println("Cart is Empty");
        }

        List<Order> orders = foody.getAllOrder();
        System.out.println("=======All Order=========");
        for(Order order: orders){
            System.out.println("Order ID: "+order.getOrderId());
            for(FoodItemDetails foodItemDetailseach:order.getCart().getFoodItemDetails()){
                System.out.println(foodItemDetailseach.getFoodItem().getName()+" "+foodItemDetailseach.getQuantity());
            }
        }
        List<Order> orderList = foody.getOrdersByUser(u1);
        System.out.println("=======All Order by User u1=========");
        for(Order order:orderList){
            System.out.println("OrderID: "+order.getOrderId()+" - "+order.getStatus()+" - "+order.getOrderDate());
            order.getCart().getFoodItemDetails().stream()
                    .map(foodItemDetails1 -> foodItemDetails1.getRestaurent().getName()+"- "+foodItemDetails1.getFoodItem().getName() + "- " + foodItemDetails1.getQuantity()+" - "+foodItemDetails1.getFoodItem().getPrice())
                    .forEach(System.out::println);
        }
    }
}