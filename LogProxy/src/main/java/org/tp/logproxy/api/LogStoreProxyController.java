package org.tp.logproxy.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.tp.logproxy.model.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Thomas Pokorny
 * api rest controller proxy to forward requests to the downstream service log service.
 */
@RestController
public class LogStoreProxyController {

    public static final String LOG_STORE_URL = System.getenv("LOGSTORE_SERVICE_HOST") != null ? System.getenv("LOGSTORE_SERVICE_HOST") : "localhost";
    public static final String LOG_STORE_PORT = System.getenv("LOGSTORE_PORT") != null ? System.getenv("LOGSTORE_PORT") : "8090";
    public static final String LOG_STORE_API_PATH = "/v1/logs";

    private static final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/store/v1/logs")
    public List<Log> getLogs() {
        Log[] logs = restTemplate.getForObject(buildURI(), Log[].class);
        return logs != null && logs.length != 0 ? new ArrayList<>(Arrays.asList(logs)) : new ArrayList<>();
    }

    @PostMapping("/store/v1/logs")
    public void createLog(@RequestBody Log log) {
        restTemplate.postForLocation(buildURI(), log);
    }

    @PutMapping("/store/v1/logs")
    public void updateLog(@RequestBody Log log) {
        restTemplate.put(buildURI(), log);
    }

    private static String buildURI() {
        String uri = String.format("http://%s:%s%s", LOG_STORE_URL, LOG_STORE_PORT, LOG_STORE_API_PATH);
        return String.format("http://%s:%s%s", LOG_STORE_URL, LOG_STORE_PORT, LOG_STORE_API_PATH);
    }
}
