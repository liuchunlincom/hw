package com.lcl.hw.framework.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by Rain on 2016/12/13 19:49.
 */
@Component
public class TimeoutUtils {
    public TimeoutUtils() {
    }

    public static long toSeconds(long timeout, TimeUnit unit) {
        return unit.toSeconds(timeout);
    }

    public static long toMillis(long timeout, TimeUnit unit) {
        return unit.toMillis(timeout);
    }
}
