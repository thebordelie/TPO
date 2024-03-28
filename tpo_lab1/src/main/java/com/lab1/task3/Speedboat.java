package com.lab1.task3;

public class Speedboat extends AbstractTransport {
    public Speedboat() {
        super("Катер", 0, 1000, 0, Type.Water);
    }

    @Override
    public void increaseSpeed(double value) throws ImpossibleSpeedException {
        if (currentSpeed + value > maxSpeed) throw new ImpossibleSpeedException("Слишком быстро!");
        currentSpeed += value;
    }

    @Override
    public void reduceSpeed(double value) throws ImpossibleSpeedException {
        if (currentSpeed - value < minSpeed) throw new ImpossibleSpeedException("Слишком медленно!");
        currentSpeed -= value;
    }

    @Override
    public String getState() {
        if (currentSpeed == 0) return "Катер стоит";
        if (currentSpeed < 200) return "Катер тихонечко плывёт";
        if (currentSpeed < 500) return "Катер рассекает просторы планеты";
        if (currentSpeed < maxSpeed) return "Катер мчится";
        return "Катер вне пространства и времени";
    }
}
