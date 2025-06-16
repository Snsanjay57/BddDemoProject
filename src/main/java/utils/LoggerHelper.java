package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
    private static Logger logger = Logger.getLogger(LoggerHelper.class);

    static {
        PropertyConfigurator.configure("src/test/resources/config/log4j.properties");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }
}
