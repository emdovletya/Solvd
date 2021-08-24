package com.solvd.ITCompany.utils;

import java.util.Random;

public class Helper {
    public static boolean isEmptyString(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> c) {
        Random random = new Random();
        int x = random.nextInt(c.getEnumConstants().length);
        return c.getEnumConstants()[x];
    }
}
