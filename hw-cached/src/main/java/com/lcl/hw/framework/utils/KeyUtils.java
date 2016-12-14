package com.lcl.hw.framework.utils;

import org.springframework.stereotype.Component;

/**
 * Created by Rain on 2016/12/13 19:35.
 */
@Component
public class KeyUtils {
    public static final String HASH_RESULT_KEY_DELIMITER = "_";
    private String prefix = System.getProperty("app.name") + "." + System.getProperty("app.env");

    public KeyUtils() {
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getKey(String key) {
        return this.getPrefix() + "." + key;
    }
}