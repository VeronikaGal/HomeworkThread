package com.galeeva.lesson25.homework.thread;

import com.galeeva.lesson25.homework.model.Crystal;
import com.galeeva.lesson25.homework.model.Mages;
import com.galeeva.lesson25.homework.util.DayConst;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {

    private final Day day;
    private final Mages mages;
    private final Planet planet;

    public Rocket(Day day, Mages mages, Planet planet) {
        this.day = day;
        this.mages = mages;
        this.planet = planet;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < DayConst.AMOUNT_OF_DAY; i++) {
                List<Crystal> crystals = gatherCrystalsFromPlanet();
                mages.addCrystals(crystals);
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<Crystal> gatherCrystalsFromPlanet() {
        List<Crystal> gatheredCrystalsFromPlanet;
        synchronized (planet.getLock()) {
            gatheredCrystalsFromPlanet = new ArrayList<>(planet.removeAll());
            System.out.printf("%s rocket gathered next crystals: %s\n", mages.getName(), gatheredCrystalsFromPlanet);
        }
        return gatheredCrystalsFromPlanet;
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }

    public Mages getMages() {
        return mages;
    }
}
