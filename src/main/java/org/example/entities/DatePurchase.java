package org.example.entities;

import java.util.Date;

public class DatePurchase {
    public int id;
    public Date date;
    public float amount;
    public String comment;
    public int categoryId;

    public DatePurchase(int id, Date date, float amount, String comment, int categoryId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
