package com.example.w23comp1008test3student;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private String category;
    private ArrayList<Review> reviews;

    public Product(String name, double price, String category) {
        setName(name);
        setPrice(price);
        setCategory(category);
        reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { // i got this name trim function off stackoverflow
        if (name == null || name.trim().isEmpty() || name.trim().length() < 3) {
            throw new IllegalArgumentException("Name should be more than 3 characters");
        }
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0 || price > 5000) {
            throw new IllegalArgumentException("price must be in the range of 0-5000");
        }
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) { // this trim function is also from stackoverflow but i made it for a catagory  instead of name
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category;  // comeback to this question
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        if (review == null) {
            throw new IllegalArgumentException("Review cannot be empty");
        }
        reviews.add(review);
    }

    public String getRating() {
        if (reviews.isEmpty()) {
            return "Nothing";
        }
        double sum = 0;
        for (Review review : reviews) {
            sum += review.getStarRating();
        }
        double average = sum / reviews.size();
        return String.format("%.1f", average); // i had to look this up to get the average using floats
    }

    public String toString() {
        return String.format("%s (%s) - $%.2f, rating: %s", name, category, price, getRating());
    }
}

