package com.daniel.reviewapp;

import java.util.ArrayList;
import java.util.List;

public class ReviewStorage {
    private static final List<String> reviews = new ArrayList<>();

    public static void addReview(String review) {
        reviews.add(review);
    }

    public static List<String> getReviews() {
        return new ArrayList<>(reviews);
    }
}
