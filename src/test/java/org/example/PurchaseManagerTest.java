package org.example;

import org.example.entities.Purchase;
import org.example.implementations.PurchaseManagerImpl;
import org.example.stubs.PurchaseStoreStub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class PurchaseManagerTest {

    private PurchaseManagerImpl manager;
    private PurchaseStoreStub store;

    @BeforeEach
    public void setup(){
        store = new PurchaseStoreStub();
        manager = new PurchaseManagerImpl(store);
    }

    @AfterEach
    public void tearDown(){
        store = null;
        manager = null;
    }

    @Test
    public void getPurchases(){
        Calendar date = Calendar.getInstance();
        date.set(2020, 2, 2);

        Purchase purchase = new Purchase(1, date, 1.0f, "Test", 1);
        Purchase[] purchases = new Purchase[]{purchase};
        store.addPurchase(purchase);

        Calendar start = Calendar.getInstance();
        start.set(2020, 1, 1);
        Calendar end = Calendar.getInstance();
        end.set(2020, 3, 3);

        Assertions.assertArrayEquals(purchases, store.getPurchases(start, end));
    }

    @Test
    public void testSumOfMonth() {
        Assertions.assertEquals(0, manager.sumOfMonth(2020, 2));
    }

    @Test
    public void testMonthlyAverage() {
        float[] expected = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f};
        Assertions.assertArrayEquals(expected, manager.monthlyAverage(2020));
    }

    @Test
    public void testYearlyAveragePerCategory() {
        float[] expected = new float[]{2.0f, 76.0f};

        Assertions.assertArrayEquals(expected, manager.yearlyAveragePerCategory(2020));
    }

}

