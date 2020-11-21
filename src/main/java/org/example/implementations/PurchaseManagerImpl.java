package org.example.implementations;

import org.example.dao.PurchaseManagerDao;

public class PurchaseManagerImpl implements PurchaseManagerDao {

    private PurchaseStoreImpl store;

    public PurchaseManagerImpl(PurchaseStoreImpl store) {
        this.store = store;
    }

    @Override
    public float sumOfMonth(int year, int month) {
        return 0;
    }

    @Override
    public float[] monthlyAverage(int year) {
        return new float[0];
    }

    @Override
    public float[] yearlyAveragePerCategory(int year) {
        return new float[0];
    }
}
