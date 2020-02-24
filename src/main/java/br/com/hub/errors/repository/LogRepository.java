package br.com.hub.errors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.hub.errors.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
    Log findById(long id);
}
