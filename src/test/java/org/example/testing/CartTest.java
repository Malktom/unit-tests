package org.example.testing;

import org.example.Cart;
import org.example.Order;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void simulatedLargeOrder() {
        // given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(10), cart::simulatedLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart(){
    //given
        Order order = new Order();
        Cart cart = new Cart();
        //when
        cart.addORderToCart(order);
        //then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(emptyCollectionOf(Order.class))
        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));
    }
}