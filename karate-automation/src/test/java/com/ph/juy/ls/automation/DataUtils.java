package com.ph.juy.ls.automation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public final class DataUtils {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String instant() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public static String instant_plus_days(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

}
