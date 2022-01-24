package org.tp.logservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tp.logservice.model.Log;
import org.tp.logservice.repository.LogStoreRepository;

import java.util.List;

/**
 * @author Thomas Pokorny
 * rest controller for the log service,
 * offers POST GET and PUT methods on '/v1/logs'.
 */
@RestController
public class LogController {

    @Autowired
    private LogStoreRepository repository;

    @GetMapping("/v1/logs")
    public List<Log> getLogs() {
        return repository.findAll();
    }

    @PostMapping("/v1/logs")
    public void createLog(@RequestBody Log log) {
        log.setEndpoint("/v1/logs");
        repository.save(log);
    }
}
