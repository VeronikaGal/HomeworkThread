package com.galeeva.lesson25.homework.util;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getNextWithRange(int min, int max) {
        return min + RANDOM.nextInt((max - min) + 1);
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }
}
