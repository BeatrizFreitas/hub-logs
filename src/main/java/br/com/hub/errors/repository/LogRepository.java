package br.com.hub.errors.repository;

import br.com.hub.errors.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID> {

    //@Query("SELECT log FROM Log log " +
     //       "where user.id = :userId and acc.id = :accelerationId")
    List<Log> findBy(@Param("allParams") Map<String, String> allParams);
}
