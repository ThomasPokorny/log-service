package org.tp.logproxy;

import org.tp.logproxy.api.LogStoreProxyController;
import org.tp.logproxy.model.Log;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Thomas Pokorny
 * PRECONDITION: running log service, waits until the service is started and reachable.
 * POSTCONDITION: created one initial default log entity.
 */
public class InitialDataFactory {
    private final int maxAttempts;
    private final int timeout;
    private final int sleep;

    public InitialDataFactory(int maxAttempts, int timeout, int sleep) {
        this.maxAttempts = maxAttempts;
        this.timeout = timeout;
        this.sleep = sleep;
    }

    public void createInitialData() {
        boolean isBookServiceRunning = checkForServiceAvailability();
        if (isBookServiceRunning) {
            LogStoreProxyController c = new LogStoreProxyController();
            c.createLog(createInitialBook());

            System.out.println(c.getLogs());
        }
    }

    private static Log createInitialBook() {
        Log initialLog = new Log();
        initialLog.setCustomText("hello from proxy");
        return initialLog;
    }

    private boolean checkForServiceAvailability() {

        System.out.println("establishing connection to server..");

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        for (int i = 0; i < maxAttempts; i++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(LogStoreProxyController.LOG_STORE_URL, new Integer(LogStoreProxyController.LOG_STORE_PORT)), timeout);
                System.out.println("[OK] connection to log-service established!");
                return true;
            } catch (IOException ignored) {
            }
        }
        System.out.println("[FAILURE] cannot establish connection to log-service");
        return false;
    }

    public static final int CONNECTION_ATTEMPTS = 20;
    public static final int TIMEOUT = 5;
    public static final int AWAIT_TIMEOUT = 10000;
}
