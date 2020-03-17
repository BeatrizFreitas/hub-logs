package br.com.hub.errors.service;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class LogService {
    private static final Logger LOG = Logger.getLogger(LogService.class);
    @Autowired
    private LogRepository logRepository;

    public Log registerLog(Log log) {
        return logRepository.save(log);
    }

    public List<Log> getLogsList(){
        List listLogs = logRepository.findAll();
        return listLogs;
    }

    public Page<Log> findAll(Specification<Log> logSpec, Pageable pageable) {
        return logRepository.findAll(logSpec, pageable);
    }
}
