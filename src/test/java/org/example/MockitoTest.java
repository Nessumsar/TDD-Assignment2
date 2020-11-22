package org.example;

import org.example.entities.Purchase;
import org.example.implementations.PurchaseManagerImpl;
import org.example.implementations.PurchaseStoreImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.mockito.Mockito.*;

public class MockitoTest {

    private PurchaseStoreImpl store;
    private PurchaseManagerImpl cut;

    @BeforeEach
    public void setup(){
        store = mock(PurchaseStoreImpl.class);
        cut = new PurchaseManagerImpl(store);
    }

    @AfterEach
    public void tearDown(){
        store = null;
        cut = null;
    }


    @Test
    public void testSumOfMonthFebruarySuccess() {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        Calendar purchaseDate = Calendar.getInstance();
        purchaseDate.set(2020, Calendar.FEBRUARY, 13, 0, 0, 0);
        startDate.set(2020, 1, 1, 0, 0, 0);
        endDate.set(2020, 1, 31, 23, 59 ,59);

        when(store.getPurchases(startDate, endDate))
                .thenReturn(new Purchase[]{
                        new Purchase(0, purchaseDate, 2.0f, "First", 0),
                        new Purchase(1, purchaseDate, 2.0f, "Second", 1)
        });
        Assertions.assertEquals(4.0f, cut.sumOfMonth(2020, 2));
    }

    @Test
    public void testSumOfMonthFail(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> cut.sumOfMonth(2020, 13));
    }

    @Test
    public void testSumOfYearFail(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> cut.sumOfMonth(2021, 1));
    }

    @Test
    public void testMonthlyAverageSuccess() {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        Calendar purchaseDate = Calendar.getInstance();
        purchaseDate.set(2020, Calendar.FEBRUARY, 13, 0, 0, 0);
        startDate.set(2020, 1, 1, 0, 0, 0);
        endDate.set(2020, 1, 31, 23, 59 ,59);

        float[] expected = {0, 8.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        when(store.getPurchases(startDate, endDate))
                .thenReturn(new Purchase[]{
                        new Purchase(0, purchaseDate, 2.0f, "First", 0),
                        new Purchase(1, purchaseDate, 2.0f, "Second", 1)
                });
        Assertions.assertArrayEquals(expected, cut.monthlyAverage(2020));
    }


    @Test
    public void testYearlyAveragePerCategorySuccess() {

    }

}
