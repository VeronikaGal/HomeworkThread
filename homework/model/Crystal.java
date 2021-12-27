package com.galeeva.lesson25.homework.model;

import java.util.Arrays;
import java.util.List;

public enum Crystal {
    WHITE_CRYSTAL,
    RED_CRYSTAL;

    public static final int MIN_CRYSTALS_COUNT = 2;
    public static final int MAX_CRYSTALS_COUNT = 5;
    public static final int AMOUNT_OF_CRYSTALS = 500;
    public static final List<Crystal> CASHED_VALUES = Arrays.asList(values());

}
