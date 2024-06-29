package com.ph.juy.ls.automation;

import java.time.Instant;
import java.util.UUID;

public final class DataUtils {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String instant() {
        return Instant.now().toString();
    }

}
