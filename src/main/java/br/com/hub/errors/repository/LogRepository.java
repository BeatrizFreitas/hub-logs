package br.com.hub.errors.repository;

import br.com.hub.errors.model.Log;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID>, JpaSpecificationExecutor<Log> {
    @Query(value = "newQuery", nativeQuery = true))
    List find_by(StringBuilder newQuery);
}


