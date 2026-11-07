package com.healthcare.config;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPERTIES = new Properties();
    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (input != null) PROPERTIES.load(input);
        } catch (Exception e) { throw new ExceptionInInitializerError(e); }
    }
    private ConfigReader() {}
    public static String get(String key, String fallback) {
        return System.getProperty(key, PROPERTIES.getProperty(key, fallback));
    }
    public static int getInt(String key, int fallback) {
        return Integer.parseInt(get(key, String.valueOf(fallback)));
    }
    public static boolean getBoolean(String key, boolean fallback) {
        return Boolean.parseBoolean(get(key, String.valueOf(fallback)));
    }
}
