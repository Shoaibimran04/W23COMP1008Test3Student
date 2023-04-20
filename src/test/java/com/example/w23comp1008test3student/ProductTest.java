package com.example.w23comp1008test3student;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class ProductTest {

    Product product;

    @org.junit.Before
    public void setUp() throws Exception {
        product = new Product("Asus 15.6",349.99,"laptops");
    }

    @org.junit.Test
    public void setName() {
        product.setName("laptop");
        assertEquals("laptop",product.getName());
    }

    @org.junit.Test
    public void setNameShort() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            product.setName("ab");});
    }

    @org.junit.Test
    public void setNameShortWithWhiteSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            product.setName(" ab ");});
    }

    //price>=0 && price<=5000
    @org.junit.Test
    public void setPrice() {
        product.setPrice(10);
        assertEquals(10, product.getPrice(), 0.0001);
    }

    @org.junit.Test
    public void setPriceLow() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            product.setPrice(-0.01);});
    }

    @org.junit.Test
    public void setPriceHigh() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            product.setPrice(5000.01);});
    }

    //"laptops","cell phones","home theatre","appliances"
    @org.junit.Test
    public void setCategoryCellPhone() {
        product.setCategory("cell phones");
        assertEquals("cell phones",product.getCategory());
    }

    @org.junit.Test
    public void setCategoryHomeTheatre() {
        product.setCategory("home THEATRE");
        assertEquals("home theatre",product.getCategory());
    }

    @org.junit.Test
    public void setCategoryAppliances() {
        product.setCategory("appliances");
        assertEquals("appliances",product.getCategory());
    }

    @org.junit.Test
    public void setCategoryInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            product.setCategory("invalid");});
    }

    @org.junit.Test
    public void setReviews() {
    }

    @org.junit.Test
    public void addReview() {
        ArrayList<Review> reviews = new ArrayList<>();
        Review newReview = new Review("Frank","great machine",4);
        reviews.add(newReview);
        product.addReview(newReview);
        assertEquals(reviews, product.getReviews());
    }

    @org.junit.Test
    public void getRating() {
        product.addReview(new Review("Frank","great machine",4));
        product.addReview(new Review("Ted","slow",1));
        product.addReview(new Review("Betty","I don't like the colour",2));
        product.addReview(new Review("Veronica","",3));
        product.addReview(new Review("Archie","great machine",4));
        product.addReview(new Review("Flipper","",5));
        //4+1+2+3+4+5 = 19/6 = 3.2
        assertEquals("3.2",product.getRating());
    }

    @org.junit.Test
    public void getRatingNoRatings() {
        assertEquals("no reviews",product.getRating());
    }

    @org.junit.Test
    public void testToString() {
        assertEquals("laptops-Asus 15.6 $349.99",product.toString());
    }
}