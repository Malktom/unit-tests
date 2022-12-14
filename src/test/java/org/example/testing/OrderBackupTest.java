package org.example.testing;

import org.example.Meal;
import org.example.Order;
import org.example.OrderBackup;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup= new OrderBackup();
        orderBackup.createFile();
    }
    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }
    @AfterEach
    void appendAtTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }


    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(7,"fries");
        Order order = new Order();
        order.addMealToOrder(meal);
        //when
        orderBackup.backupOrder(order);
        //then
        System.out.println("Order: "+ order.toString() + " backed up" );
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }
}
