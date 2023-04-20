package com.example.w23comp1008test3student;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class ReviewTest {
    private Review review;

    @Before
    public void setUp() throws Exception {
        review = new Review("Aaralyn","Great stuff!",5);
    }

    //constructor validation

    @Test
    public void setReviewerName() {
        review.setReviewerName("Alfred");
        assertEquals("Alfred",review.getReviewerName());
    }

    @Test
    public void setNameInvalidWithSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            review.setReviewerName(" a ");});
    }
    @Test
    public void setNameInvalidShort() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            review.setReviewerName("a");});
    }

    @Test
    public void setNameInvalidShortConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Review(" a ","",4);});
    }

    @Test
    public void setDescription() {
        review.setDescription("awesome");
        assertEquals("awesome",review.getDescription());
    }

    @Test
    public void setDescriptionEmpty() {
        review.setDescription("");
        assertEquals("no comment",review.getDescription());
    }

    @Test
    public void setDescriptionEmptySpaces() {
        review.setDescription("    ");
        assertEquals("no comment",review.getDescription());
    }

    @Test
    public void setDescriptionEmptySpacesLongConstructor() {
        String description = "1234567890101";
        for (int i=1; i<=4; i++)
            description += description;
        final String desc = description;

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Review("Albert",desc,4);});
    }

    @Test
    public void setDescriptionEmptySpacesLong() {
        String description = "1234567890101";
        for (int i=1; i<=4; i++)
            description += description;
        final String desc = description;

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            review.setDescription(desc);});
    }

    @Test
    public void setStarRating() {
        review.setStarRating(3);
        assertEquals(3, review.getStarRating());
    }

    @Test
    public void setStarRatingInvalidLow() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            review.setStarRating(-1);});
    }
    @Test
    public void setStarRatingInvalidHigh() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            review.setStarRating(6);});
    }
}