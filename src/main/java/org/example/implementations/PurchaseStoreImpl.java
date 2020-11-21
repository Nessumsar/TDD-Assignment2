package org.example.implementations;
import org.example.dao.PurchaseStoreDao;
import org.example.entities.Category;
import org.example.entities.Purchase;

import java.util.Calendar;

public class PurchaseStoreImpl implements PurchaseStoreDao {

    @Override
    public Purchase[] getPurchases(Calendar startDate, Calendar endDate) {
        return new Purchase[0];
    }

    @Override
    public Purchase[] getPurchasesByCategory(Calendar startDate, Calendar endDate, int catId) {
        return new Purchase[0];
    }

    @Override
    public Category[] getAllCategories() {
        return new Category[0];
    }
}
