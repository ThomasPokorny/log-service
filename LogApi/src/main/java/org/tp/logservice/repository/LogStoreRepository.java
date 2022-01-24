package org.tp.logservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tp.logservice.model.Log;

public interface LogStoreRepository extends JpaRepository<Log, Integer> {
}
