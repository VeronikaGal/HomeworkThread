package com.galeeva.lesson25.homework.thread;

import com.galeeva.lesson25.homework.model.Crystal;
import com.galeeva.lesson25.homework.util.DayConst;
import com.galeeva.lesson25.homework.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Planet extends Thread {

    private final Object lock = new Object();
    private final Day day;
    private final List<Crystal> crystalList = new ArrayList<>();

    public Planet(Day day) {
        this(day, Collections.emptyList());
    }

    public Planet(Day day, List<Crystal> list) {
        this.day = day;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < DayConst.AMOUNT_OF_DAY; i++) {
                growCrystals();
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void growCrystals() {
        int countCrystalsForGrowing = RandomUtil.getNextWithRange(Crystal.MIN_CRYSTALS_COUNT, Crystal.MAX_CRYSTALS_COUNT);
        synchronized (lock) {
            for (int j = 0; j < countCrystalsForGrowing; j++) {
                Crystal crystal = Crystal.CASHED_VALUES.get(RandomUtil.getNext(Crystal.CASHED_VALUES.size()));
                crystalList.add(crystal);
            }
            System.out.println("Planet grew crystals. Count: " + countCrystalsForGrowing);
        }
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }

    public void add(Crystal crystal) {
        crystalList.add(crystal);
    }

    public List<Crystal> removeAll() {
        List<Crystal> crystals = new ArrayList<>(crystalList);
        crystalList.clear();
        return crystals;
    }

    public int size() {
        return crystalList.size();
    }

    public Object getLock() {
        return lock;
    }
}
