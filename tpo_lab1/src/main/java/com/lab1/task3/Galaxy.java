package com.lab1.task3;

import java.util.HashMap;

public class Galaxy {
    private HashMap<Star, Integer> locations;
    private HashMap<String, Star> stars;

    public Galaxy(HashMap<Star, Integer> locations) {
        this.locations = locations;
        stars = new HashMap<>();
        for (Star star : locations.keySet()) {
            stars.put(star.getStarName(), star);
        }
    }

    public HashMap<String, Star> getStars() {
        return stars;
    }

    public int findDistanceBetweenStars(String starName1, String starName2) {
        Star star1 = stars.get(starName1);
        Star star2 = stars.get(starName2);
        return Math.abs(locations.get(star1) - locations.get(star2));
    }
}
