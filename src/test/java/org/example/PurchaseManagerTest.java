package org.example;

import org.example.entities.Category;
import org.example.entities.Purchase;
import org.example.implementations.PurchaseManagerImpl;
import org.example.stubs.PurchaseStoreStub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class PurchaseManagerTest {

    private PurchaseManagerImpl cut;
    private PurchaseStoreStub store;

    @BeforeEach
    public void setup(){
        store = new PurchaseStoreStub();
        cut = new PurchaseManagerImpl(store);
    }

    @AfterEach
    public void tearDown(){
        store = null;
        cut = null;
    }

    @Test
    public void testSumOfMonthFebruarySuccess() {
        Calendar date = Calendar.getInstance();
        date.set(2020, 1, 13);
        Purchase purchase1 = new Purchase(1, date, 2.0f,"First", 1);
        Purchase purchase2 = new Purchase(2, date, 2.0f, "Second", 2);

        store.addPurchase(purchase1);
        store.addPurchase(purchase2);
        Assertions.assertEquals(4.0f, cut.sumOfMonth(2020, 2));
    }

    @Test
    public void testSumOfMonthFail(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> cut.sumOfMonth(2020, 13));
    }

    @Test
    public void testSumOfYearFail(){
        Calendar date = Calendar.getInstance();
        date.set(2020, 2, 2);
        Purchase purchase1 = new Purchase(1, date, 2.0f,"First", 1);
        Purchase purchase2 = new Purchase(2, date, 2.0f, "Second", 2);

        store.addPurchase(purchase1);
        store.addPurchase(purchase2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> cut.sumOfMonth(2021, 13));
    }

    @Test
    public void testMonthlyAverageSuccess() {
        Calendar date = Calendar.getInstance();
        date.set(2020, 1, 2);
        Purchase purchase1 = new Purchase(1, date, 2.0f,"First", 1);
        Purchase purchase2 = new Purchase(2, date, 2.0f, "Second", 2);

        store.addPurchase(purchase1);
        store.addPurchase(purchase2);

        float[] expected = new float[]{0.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        Assertions.assertArrayEquals(expected, cut.monthlyAverage(2020));
    }

    @Test
    public void testYearlyAveragePerCategorySuccess() {
        Category category1 = new Category(0, "Cool");
        Category category2 = new Category(1, "Nice");
        store.addCategory(category1);
        store.addCategory(category2);

        Calendar date = Calendar.getInstance();
        date.set(2020, 1, 2);
        Purchase purchase1 = new Purchase(1, date, 2.0f,"First", 0);
        Purchase purchase2 = new Purchase(2, date, 2.0f, "Second", 1);
        store.addPurchase(purchase1);
        store.addPurchase(purchase2);

        float[] expected = new float[]{2.0f, 2.0f};
        Assertions.assertArrayEquals(expected, cut.yearlyAveragePerCategory(2020));
    }

}

