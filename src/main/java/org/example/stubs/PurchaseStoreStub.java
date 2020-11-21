package org.example.stubs;

import org.example.entities.Category;
import org.example.entities.Purchase;
import org.example.implementations.PurchaseStoreImpl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class PurchaseStoreStub extends PurchaseStoreImpl {

    private List<Purchase> purchases = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
    }

    public void addCategory(Category category){
        categories.add(category);
    }


    @Override
    public Purchase[] getPurchases(Calendar startDate, Calendar endDate) {
       Purchase[] result = purchases.stream()
               .filter(purchase -> startDate.before(purchase.date) )
               .filter(purchase -> endDate.after(purchase.date))
               .toArray(Purchase[]::new);

       if (result.length == 0){
          throw new NullPointerException();
       }

        return result;
    }

    @Override
    public Purchase[] getPurchasesByCategory(Calendar startDate, Calendar endDate, int catId) {
        return super.getPurchasesByCategory(startDate, endDate, catId);
    }

    @Override
    public Category[] getAllCategories() {
        return super.getAllCategories();
    }
}
