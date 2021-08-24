package com.solvd.ITCompany.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    private void pingBD(String message) {
        LOGGER.info(message);
    }

    private void authBD(String message) {
        LOGGER.info(message);
    }

    private void infoBD(String message) {
        LOGGER.info(message);
    }

    private void executeQuery(String message) {
        LOGGER.info(message);
    }

    private void close(String message) {
        LOGGER.info(message);
    }
}
