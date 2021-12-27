package com.galeeva.lesson25.homework.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mages {

    private final Map<Crystal, Integer> crystals = new EnumMap<>(Crystal.class);
    private final String name;

    public Mages(String name) {
        this.name = name;
    }

    public void addCrystals(List<Crystal> list) {
        for (Crystal crystal : list) {
            crystals.merge(crystal, 1, Integer::sum);
        }
    }

    public Map<Crystal, Integer> getCrystals() {
        Map<Crystal, Integer> hashMap = new HashMap<>();
        Set<Map.Entry<Crystal, Integer>> entrySet = crystals.entrySet();
        for (Map.Entry<Crystal, Integer> entry : entrySet) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Crystal, Integer> integerEntry : hashMap.entrySet()) {
            System.out.println(integerEntry.getKey() + " :" + integerEntry.getValue());
        }
        return hashMap;
    }

    public String getName() {
        return name;
    }
}
