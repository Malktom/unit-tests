package org.example.testing;

import org.example.Meal;
import org.example.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    @BeforeEach
    void initializeOrder(){
        System.out.println("Inside @BeforeEach method");
        order = new Order();
    }
    @AfterEach
    void cleanUp(){
        System.out.println("Inside @AfterEach method");
        order.cancel();
    }

    @Test
    void testAssertArrayEquals(){
        //given
        int[] inst1 = {1,2,3};
        int[] inst2 = {1,2,3};

        //then
        assertArrayEquals(inst1,inst2);
    }
    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder(){
        //given
//        Order order = new Order(); dzieki metodzie @BeforeEach nie musimy tworzyc za kazdym razem nowego obiektu

        //then
        assertThat(order.getMeals(),empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }
    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        //given
//        Order order = new Order();
        Meal meal1 = new Meal(30,"picka");
        Meal meal2 = new Meal(25,"burger");
        //when
        order.addMealToOrder(meal1);

        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal1));
        assertThat(order.getMeals(), hasItem(meal1));
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize(){
        //given
//        Order order = new Order();
        Meal meal1 = new Meal(30,"picka");
        Meal meal2 = new Meal(25,"burger");
        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        order.removeMealFromOrder(meal1);

        //then
//        assertThat(order.getMeals(),hasSize(0));
        assertThat(order.getMeals(), contains(meal2));
        assertThat(order.getMeals(), not(contains(meal1)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder(){
        //given
//        Order order = new Order();
        Meal meal1 = new Meal(30,"picka");
        Meal meal2 = new Meal(25,"burger");
        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        //then
        assertThat(order.getMeals(), containsInAnyOrder(meal2,meal1));
    }
}
