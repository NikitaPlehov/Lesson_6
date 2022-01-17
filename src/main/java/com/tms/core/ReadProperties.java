package com.tms.core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties = null;
    private static String filename = "config.properties";

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getBrowserName() {
        return properties.getProperty("browser");
    }

    //public static String getType1Name() {return properties.getProperty("type1");}

    public static String getType2Name() {return properties.getProperty("type2");}

    //public static String getType3Name() {return properties.getProperty("type3");}

    public static String getUsername() {return properties.getProperty("username");}

    public static String getPassword() {return properties.getProperty("password");}

    public static String getName() {return properties.getProperty("name");}

    public static String getAnnouncement() {return properties.getProperty("announcement");}

    public static boolean isHeadless() {return properties.getProperty("headless").equalsIgnoreCase("true");}

    public static int getTimeOut() {return Integer.parseInt(properties.getProperty("timeout"));}
}
