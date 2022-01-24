package org.tp.logproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Thomas Pokorny
 * The api proxy application LogProxy for the LogService downstream rest service.
 */
@SpringBootApplication
public class LogProxy {
    public static void main(String... args) {
        SpringApplication.run(LogProxy.class, args);

        InitialDataFactory init = new InitialDataFactory(
                InitialDataFactory.CONNECTION_ATTEMPTS,
                InitialDataFactory.TIMEOUT,
                InitialDataFactory.AWAIT_TIMEOUT);

        init.createInitialData();
    }
}
