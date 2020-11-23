package org.example;

import org.example.entities.Category;
import org.example.entities.DatePurchase;
import org.example.implementations.PurchaseManagerWithDate;
import org.example.implementations.PurchaseStoreWithDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.mockito.Mockito.*;

public class MockitoTest {

    private PurchaseStoreWithDate store;
    private PurchaseManagerWithDate cut;

    @BeforeEach
    public void setup(){
        store = mock(PurchaseStoreWithDate.class);
        cut = new PurchaseManagerWithDate(store);
    }

    @AfterEach
    public void tearDown(){
        store = null;
        cut = null;
    }

    @Test
    public void testSumOfMonthFebruarySuccess() {
        Date purchaseDate = new Date(2020, 1, 13, 0, 0, 0);;
        Date startDate = new Date(2020, 1, 1, 0, 0, 0);
        Date endDate = new Date(2020, 1, 29, 23, 59 ,59);

        when(store.getPurchases(startDate, endDate))
                .thenReturn(new DatePurchase[]{
                        new DatePurchase(0, purchaseDate, 2.0f, "First", 0),
                        new DatePurchase(1, purchaseDate, 2.0f, "Second", 1)
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
        float[] expected = {0, 4.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Date purchaseDate = new Date(2020, 1, 13, 0, 0, 0);;
        Date startDate = new Date(2019, 11, 31, 0, 0, 0);
        Date endDate = new Date(2021, 0, 1, 0, 0, 0);

        when(store.getPurchases(startDate, endDate))
                .thenReturn(new DatePurchase[]{
                        new DatePurchase(0, purchaseDate, 2.0f, "First", 0),
                        new DatePurchase(1, purchaseDate, 2.0f, "Second", 1)
                });
        Assertions.assertArrayEquals(expected, cut.monthlyAverage(2020));
    }


    @Test
    public void testYearlyAveragePerCategorySuccess() {
        float[] expected = {2.0f, 2.0f};
        Date purchaseDate = new Date(2020, 1, 13, 0, 0, 0);;
        Date startDate = new Date(2019, 11, 31, 0, 0, 0);
        Date endDate = new Date(2021, 0, 1, 0, 0, 0);

        when(store.getAllCategories()).thenReturn(new Category[]{
                new Category(0, "Cool"),
                new Category(1, "Proper")
        });
        when(store.getPurchasesByCategory(startDate, endDate, 0))
                .thenReturn(new DatePurchase[]{
                        new DatePurchase(0, purchaseDate, 2.0f, "First", 0)
                });
        when(store.getPurchasesByCategory(startDate, endDate, 1))
                .thenReturn(new DatePurchase[]{
                        new DatePurchase(1, purchaseDate, 2.0f, "Second", 1)
                });

        Assertions.assertArrayEquals(expected, cut.yearlyAveragePerCategory(2020));
    }

}
