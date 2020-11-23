package org.example.implementations;

import org.example.entities.DatePurchase;
import org.example.entities.Purchase;

import java.util.Calendar;
import java.util.Date;

public class PurchaseManagerWithDate {

    private PurchaseStoreWithDate store;

    public PurchaseManagerWithDate(PurchaseStoreWithDate store) {
        this.store = store;
    }


    public float sumOfMonth(int year, int month) {
        int days = 0;
        if (month > 12 || year > Calendar.getInstance().get(Calendar.YEAR)){
            throw new IllegalArgumentException();
        } else if (month == 4 || month == 6 || month == 9 || month == 11){
            days = 30;
        } else if (month == 2){
            days = 28;
            if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)){
                days = 29;
            }
        }else{
            days = 31;
        }
        Date startDate = new Date(year, month-1, 1, 0, 0, 0);
        Date endDate = new Date(year, month-1, days, 23, 59, 59);

        var purchases = store.getPurchases(startDate, endDate);
        float sum = 0.0f;


        for (int i=0; i<purchases.length; i++){
            sum += purchases[i].amount;
        }

        return sum;
    }


    public float[] monthlyAverage(int year) {

        Date startDate = new Date(year-1, 11, 31, 0, 0, 0);
        Date endDate = new Date(year+1, 0, 1, 0, 0, 0);

        var purchases = store.getPurchases(startDate, endDate);
        float[] result = new float[12];

        for (int i=0; i<result.length; i++){
            int sum = 0;
            for (DatePurchase p : purchases){
                if (p.date.getMonth() == i){
                    sum += p.amount;
                }
            }
            result[i] = sum;
        }
        return result;
    }


    public float[] yearlyAveragePerCategory(int year) {
        Date startDate = new Date(year-1, 11, 31, 0, 0, 0);
        Date endDate = new Date(year+1, 0, 1, 0, 0, 0);
        var categories = store.getAllCategories();
        var result = new float[categories.length];

        for (int i=0; i<categories.length; i++) {
            int sum = 0;
            var purchases = store.getPurchasesByCategory(startDate, endDate, i);

            for (DatePurchase purchase : purchases){
                sum += purchase.amount;
            }
            result[i] = sum;
        }
        return result;
    }


}
