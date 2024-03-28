package com.lab1.task3;

import java.util.ArrayList;

public class Planet {
    private double averageTemperature;
    private String name;
    private ArrayList<Type> climates;

    public Planet(double averageTemperature, String name, ArrayList<Type> climates) {
        this.averageTemperature = averageTemperature;
        this.name = name;
        this.climates = climates;
    }

    public String getName() {
        return name;
    }

    public boolean checkClimate(Type climate) {
        return climates.stream().anyMatch(climate1 -> climate1.equals(climate));
    }

    public boolean checkDevice(AbstractTransport transport) {
        return climates.stream().anyMatch(climate -> climate == transport.type);
    }
}
