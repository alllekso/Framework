package exercise;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demolog {
    protected static final Logger LOG = LogManager.getLogger(Demolog.class);
    public static void main(String[] args) {
        System.out.println("Hello Logs");
        LOG.debug("Start logging", "test");

    }
}
