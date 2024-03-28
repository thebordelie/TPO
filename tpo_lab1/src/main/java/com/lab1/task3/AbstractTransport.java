package com.lab1.task3;

public abstract class AbstractTransport {
    protected String name;
    protected final double minSpeed;
    protected final double maxSpeed;
    protected double currentSpeed;
    protected Type type;

    public AbstractTransport(String name, double minSpeed, double maxSpeed, double currentSpeed, Type type) {
        this.name = name;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.type = type;
    }

    abstract public void increaseSpeed(double value) throws ImpossibleSpeedException;

    abstract public void reduceSpeed(double value) throws ImpossibleSpeedException;

    abstract public String getState();

}
