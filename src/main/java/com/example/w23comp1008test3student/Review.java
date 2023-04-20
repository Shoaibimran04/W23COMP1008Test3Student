package com.example.w23comp1008test3student;

public class Review {
    private String reviewerName;
    private String description;
    private int starRating;


    public Review(String reviewerName, String description, int starRating) {
        setReviewerName(reviewerName);
        setDescription(description);
        setStarRating(starRating);
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        if (reviewerName.trim().length() < 2) {
            throw new IllegalArgumentException("Reviewer name must be 2 or more characters");
        }
        this.reviewerName = reviewerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.trim().isEmpty()) {
            this.description = "no comment";
        } else if (description.length() > 200) {
            throw new IllegalArgumentException("Description must be 200 characters or less");
        } else {
            this.description = description;
        }
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        if (starRating < 0 || starRating > 5) {
            throw new IllegalArgumentException("Star rating must be an integer in the range of 0-5");
        }
        this.starRating = starRating;
    }

}

