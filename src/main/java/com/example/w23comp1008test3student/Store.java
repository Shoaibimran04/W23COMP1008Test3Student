package com.example.w23comp1008test3student;

import java.util.ArrayList;

public class Store {
    private String streetName;
    private int streetNumber;
    private String storeName;
    private ArrayList<Product> products;

    public Store(String storeName, String streetName, int streetNumber) {
        setStoreName(storeName);
        setStreetName(streetName);
        setStreetNumber(streetNumber);
        products = new ArrayList<>();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {    // https://stackoverflow.com/questions/26722496/regex-difference-between-a-za-z-vs-a-za-z
        if (streetName == null || streetName.trim().length() < 2 || !streetName.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("Street name should only contain letters and must be atleast 2 charaters long");
        }
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        if (streetNumber < 1 || streetNumber > 10000) {
            throw new IllegalArgumentException("Street number should be in the range of 1-10,000");
        }
        this.streetNumber = streetNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        if (storeName == null || storeName.trim().length() < 2) {
            throw new IllegalArgumentException("Store name should be 2 or more characters");
        }
        this.storeName = storeName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getNumOfProducts() {
        return products.size();
    }

    public double getInventoryValue() {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getPrice();
        }
        return totalValue;
    }
}

