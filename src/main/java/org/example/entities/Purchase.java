package org.example.entities;

import java.util.Calendar;

public class Purchase {

    public int id;
    public Calendar date;
    public float amount;
    public String comment;
    public int categoryId;

    public Purchase(int id, Calendar date, float amount, String comment, int categoryId) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.comment = comment;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
