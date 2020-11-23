package org.example.implementations;

import org.example.entities.Category;
import org.example.entities.DatePurchase;
import org.example.entities.Purchase;

import java.util.Calendar;
import java.util.Date;

public class PurchaseStoreWithDate {


    public DatePurchase[] getPurchases(Date startDate, Date endDate) {
        return new DatePurchase[0];
    }


    public DatePurchase[] getPurchasesByCategory(Date startDate, Date endDate, int catId) {
        return new DatePurchase[0];
    }


    public Category[] getAllCategories() {
        return new Category[0];
    }
}
