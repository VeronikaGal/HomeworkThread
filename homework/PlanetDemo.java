package com.galeeva.lesson25.homework;

import com.galeeva.lesson25.homework.model.Mages;
import com.galeeva.lesson25.homework.thread.Day;
import com.galeeva.lesson25.homework.thread.Planet;
import com.galeeva.lesson25.homework.thread.Rocket;
import com.galeeva.lesson25.homework.util.ThreadUtil;

public class PlanetDemo {

    private volatile static boolean flag;

    public static void main(String[] args) throws InterruptedException {
        Day day = new Day();
        Planet planet = new Planet(day);

        Rocket fireMagesRocket = new Rocket(day, new Mages("FireMages"), planet);
        Rocket airMagesRocket = new Rocket(day, new Mages("AirMages"), planet);

        ThreadUtil.startThreads(day, planet, fireMagesRocket, airMagesRocket);
        ThreadUtil.joinThreads(day, planet, fireMagesRocket, airMagesRocket);

//        ThreadUtil.interruptThreads(day, planet, fireMagesRocket, airMagesRocket);
        viewStatistic(fireMagesRocket.getMages(), airMagesRocket.getMages());
    }

    private static void viewStatistic(Mages fireMages, Mages airMages) {
        System.out.println("----------------");
        System.out.println(fireMages.getName());
        fireMages.getCrystals();
        System.out.println(airMages.getName());
        airMages.getCrystals();
    }
}

