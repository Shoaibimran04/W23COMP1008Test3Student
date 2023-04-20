package com.example.w23comp1008test3student;

import com.example.w23comp1008test3student.Product;

import java.util.ArrayList;

public class ProductCreator {
    public static ArrayList<Product> getProducts()
    {
        ArrayList<Product> products = new ArrayList<>();
        Product product1 = new Product("Asus 15.6",349.99,"laptops");
        product1.addReview(new Review("Frank","great machine",4));
        product1.addReview(new Review("Ted","slow",1));
        product1.addReview(new Review("Betty","I don't like the colour",2));
        product1.addReview(new Review("Veronica","",3));
        product1.addReview(new Review("Archie","great machine",4));
        product1.addReview(new Review("Flipper","",5));

        Product product2 = new Product("Dell Inspiron",1449.99,"laptops");
        product2.addReview(new Review("Aaralyn","",5));
        product2.addReview(new Review("Christy","",5));
        product2.addReview(new Review("Chantel","",4));

        Product product3 = new Product("Acer Asprie",449.99,"laptops");
        Product product4 = new Product("Apple iPhone 13",999.99,"cell phones");
        product3.addReview(new Review("Disha","love it",4));
        product3.addReview(new Review("Madilyn","Sweet Phone!!",4));
        product3.addReview(new Review("Florence","",4));

        Product product5 = new Product("Apple iPhone 14 Pro",1699.99,"cell phones");
        Product product6 = new Product("Google Pixel 6a",4999.9999,"cell phones");
        Product product7 = new Product("LG 77inch UHD HDR OLED",3799.9999,"home theatre");
        Product product8 = new Product("Sony Bravia 85",2699.9999,"home theatre");
        Product product9 = new Product("Sony X80K",2299.9999,"home theatre");

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        return products;
    }
}
