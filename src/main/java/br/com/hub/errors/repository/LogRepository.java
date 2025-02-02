package br.com.hub.errors.repository;

import br.com.hub.errors.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID>, JpaSpecificationExecutor<Log> {

}
