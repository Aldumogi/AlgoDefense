package edu.fiuba.algo3.modelo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerManager {
    static {
        String configLocation = "src/main/java/edu/fiuba/algo3/resources/log4j2.xml";
        Configurator.initialize(null, configLocation);
    }

    public static final Logger logger = LogManager.getLogger(LoggerManager.class);
}

