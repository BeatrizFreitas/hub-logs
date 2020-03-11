package br.com.hub.errors.service;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
        //TODO: implementar paginçao quando retornar o getall

        // PageRequest pageReq
        //          = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        List listLogs = logRepository.findAll();

        return listLogs;
    }

    public List<Log> find_by(Map<String, String> allParams){
        return logRepository.findBy(allParams);
    }

    public Optional<Log> get(UUID id) {return logRepository.findById(id);}
}
