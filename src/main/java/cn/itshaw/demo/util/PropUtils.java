package cn.itshaw.demo.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Logger;

public class PropUtils {
    private static final String propFileName = "/config.properties";
    private static final Logger logger = Logger.getLogger(PropUtils.class.getName());
    private static Properties prop = null;

    public PropUtils() {
    }

    private static String replaceChars(String value, String[] messages) {
        MessageFormat format = new MessageFormat(value);
        return format.format(messages);
    }

    public static String getPropValue(String key, String[] messages) {
        String value = prop.getProperty(key);
        return replaceChars(value, messages);
    }

    public static String getProp(String key) {
        String value = prop.getProperty(key);
        if(value == null) {
            logger.info("the properties is not found.");
            return "系统异常";
        } else {
            return value;
        }
    }

    public static String getProp(String key, String defaultValue) {
        String value = prop.getProperty(key);
        return value == null?defaultValue:value;
    }

    public static String[] getProps(String key) {
        String value = prop.getProperty(key);
        return value.split(",");
    }

    public static String getProp(int key) {
        return getProp(String.valueOf(key));
    }

    public static String getProp(int key, String[] msg) {
        return getPropValue(String.valueOf(key), msg);
    }

    static {
        prop = new Properties();

        try {
            prop.load(PropUtils.class.getResourceAsStream(propFileName));
        } catch (FileNotFoundException var1) {
            logger.info("the property file is not found!");
        } catch (IOException var2) {
            logger.info("reading property file error,please check!");
        }

    }
}
