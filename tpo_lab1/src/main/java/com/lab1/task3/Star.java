package com.lab1.task3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Star {
    private String starName;
    private ArrayList<Planet> planets;

    public Star(String starName, ArrayList<Planet> planets) {
        this.starName = starName;
        this.planets = planets;
    }

    public String getStarName() {
        return starName;
    }

    public Planet getPlanet(String name) {
        return planets.stream().filter(planet -> planet.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public int getPlanetCount() {
        return planets.size();
    }
}
