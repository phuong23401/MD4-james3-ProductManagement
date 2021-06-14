package model;

import java.util.Date;

public class Product {
    private int id;
    private String name, description, manuDate, expiryDate;

    public Product(int id, String name, String description, String manuDate, String expiryDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manuDate = manuDate;
        this.expiryDate = expiryDate;
    }

    public Product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManuDate() {
        return manuDate;
    }

    public void setManuDate(String manuDate) {
        this.manuDate = manuDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
