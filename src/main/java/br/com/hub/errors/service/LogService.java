package br.com.hub.errors.service;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import br.com.hub.errors.specification.LogSpecs;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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


    public List<Log> findAllFilters(Map<String, String> allParams) {
        return logRepository.findAll(LogSpecs.getLogsByFilters(allParams));
    }

}
