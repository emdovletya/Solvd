package com.solvd.ITCompany.utils.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ConnectionsTask {
    private static final int FREE_POOL_TIMEOUT = 1000;
    private static final int EXECUTE_QUERY_TIMEOUT = 500;
    private static final Logger LOGGER = LogManager.getLogger(ConnectionsTask.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public static void main(String[] args) {
        Runnable r = () -> {
            Thread currentThread = Thread.currentThread();
            String currentThreadName = currentThread.getName();

            try {
                Thread.sleep(500);
                while (!CONNECTION_POOL.hasFreeConnections()) {
                    LOGGER.info(currentThreadName + "in queue");
                    Thread.sleep(FREE_POOL_TIMEOUT);
                }
                createConnectionWithThreadName(currentThreadName);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
        };

        run(r);
    }

    public static void createConnectionWithThreadName(String threadName) throws InterruptedException {
        Connection connection = CONNECTION_POOL.getConnection();
        connection.pingBD(threadName);
        connection.authBD(threadName);
        connection.infoBD(threadName);
        connection.executeQuery(threadName);

        Thread.sleep(EXECUTE_QUERY_TIMEOUT);

        CONNECTION_POOL.releaseConnection(connection);
    }

    public static void run(Runnable r) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            threads.add(new Thread(r, "thread "+ i));
            threads.get(i).start();
        }
    }
}


