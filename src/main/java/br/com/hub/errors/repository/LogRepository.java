package br.com.hub.errors.repository;

import br.com.hub.errors.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {

}
