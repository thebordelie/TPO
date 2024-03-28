package com.lab1.task3;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;

public class StatesTest {
    private Galaxy galaxy;
    private Speedboat speedboat;

    public StatesTest(){
        Planet earth = new Planet(25, "Earth", new ArrayList<Type>() {{
            add(Type.Earth);
            add(Type.Water);
        }});
        Planet mars = new Planet(-15, "Mars", new ArrayList<Type>() {{
            add(Type.Earth);
        }});
        Star sun = new Star("Sun", new ArrayList<Planet>() {
            {
                add(earth);
                add(mars);
            }
        });
        Planet damocran = new Planet(20, "Damocran", new ArrayList<Type>() {{
            add(Type.Earth);
            add(Type.Water);
        }});
        Star damocran_sun = new Star("Damocran Sun", new ArrayList<Planet>() {
            {
                add(damocran);
            }
        });
        HashMap<Star, Integer> locations = new HashMap<>();
        locations.put(sun, 0);
        locations.put(damocran_sun, 500);
        galaxy = new Galaxy(locations);
        speedboat = new Speedboat();
    }

    @BeforeEach
    void resetSpeed(){
        speedboat.currentSpeed = 0;
    }

    @Test
    @DisplayName("check speed")
    void checkSpeed() {
        try {
            speedboat.increaseSpeed(10);
            speedboat.increaseSpeed(10);
            speedboat.increaseSpeed(10);
            speedboat.increaseSpeed(10);
            speedboat.reduceSpeed(10);
            Assertions.assertEquals(30, speedboat.currentSpeed);
        } catch (ImpossibleSpeedException ignored) {
        }
    }

    @Test
    @DisplayName("check maximum speed exception")
    void checkMaxSpeed() {
        Throwable throwable = Assertions.assertThrows(ImpossibleSpeedException.class, ()-> speedboat.increaseSpeed(10000));
        Assertions.assertEquals("Слишком быстро!", throwable.getMessage());
    }

    @Test
    @DisplayName("check min speed exception")
    void checkMinSpeed() {
        Throwable throwable = Assertions.assertThrows(ImpossibleSpeedException.class, ()-> speedboat.reduceSpeed(50000));
        Assertions.assertEquals("Слишком медленно!", throwable.getMessage());
    }

    @Test
    @DisplayName("check speedboat states")
    void checkStates(){
        Assertions.assertEquals("Катер стоит", speedboat.getState());
        speedboat.currentSpeed = 15;
        Assertions.assertEquals("Катер тихонечко плывёт", speedboat.getState());
        speedboat.currentSpeed = 225;
        Assertions.assertEquals("Катер рассекает просторы планеты", speedboat.getState());
        speedboat.currentSpeed = 600;
        Assertions.assertEquals("Катер мчится", speedboat.getState());
        speedboat.currentSpeed = 2000;
        Assertions.assertEquals("Катер вне пространства и времени", speedboat.getState());

    }

    @Test
    @DisplayName("check distance between start")
    void checkDistance(){
        Assertions.assertEquals(500, galaxy.findDistanceBetweenStars("Damocran Sun", "Sun"));

    }

    @Test
    @DisplayName("check planet count")
    void checkPlanet(){
        Assertions.assertEquals(2, galaxy.getStars().get("Sun").getPlanetCount());
    }

    @Test
    @DisplayName("check types")
    void checkPlanetTypes(){
        Assertions.assertTrue(galaxy.getStars().get("Damocran Sun").getPlanet("Damocran").checkClimate(Type.Water));
    }

    @Test
    @DisplayName("check transport")
    void checkTransportTypes(){
        Assertions.assertTrue(galaxy.getStars().get("Damocran Sun").getPlanet("Damocran").checkDevice(speedboat));
    }


}
