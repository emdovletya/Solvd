package com.solvd.ITCompany.utils.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void pingBD(String message) {
        LOGGER.info(message);
    }

    public void authBD(String message) {
        LOGGER.info(message);
    }

    public void infoBD(String message) {
        LOGGER.info(message);
    }

    public void executeQuery(String message) {
        LOGGER.info(message);
    }

    public void close(String message) {
        LOGGER.info(message);
    }
}
