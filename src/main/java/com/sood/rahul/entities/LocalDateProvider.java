package com.sood.rahul.entities;

import java.time.LocalDate;

public class LocalDateProvider {
    private static LocalDateProvider instance = null;

    /**
     * @return make sure to return singleton instance
     */
    public static LocalDateProvider singleton() {
        if (instance == null) {
            instance = new LocalDateProvider();
        }
            return instance;
        }

    public LocalDate currentDate() {
            return LocalDate.now();
    }
}
