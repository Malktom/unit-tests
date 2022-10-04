package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Order> getOrders() {
        return orders;
    }

    private List<Order> orders = new ArrayList<>();
    
    public void addORderToCart(Order order){
        this.orders.add(order);
        
    }
   public void clearCart(){
        this.orders.clear();
    }
    
    public void simulatedLargeOrder(){
        for (int i = 0; i < 1_000; i++) {
            Meal meal = new Meal(i%10,"Hamburger no " + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addORderToCart(order);
        }
        System.out.println("Cart size: "+ orders.size());
        clearCart();
    }
}
