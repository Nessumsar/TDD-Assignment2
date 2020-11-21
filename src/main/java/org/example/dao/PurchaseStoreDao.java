package org.example.dao;

import org.example.entities.Category;
import org.example.entities.Purchase;

import java.util.Calendar;

public interface PurchaseStoreDao {

    /**
     * Get purchases from startDate to endDate.
     * @param startDate
     * @param endDate
     * @return Purchases.
     */
    Purchase[] getPurchases(Calendar startDate, Calendar endDate);
    /**
     * Get purchases from startDate to endDate for category catId.
     * @param startDate
     * @param endDate
     * @param catId
     * @return Purchases.
     */
    Purchase[] getPurchasesByCategory(Calendar startDate, Calendar endDate, int catId);
    /**
     * Get all categories.
     * @return Categories.
     */
    Category[] getAllCategories();

}
