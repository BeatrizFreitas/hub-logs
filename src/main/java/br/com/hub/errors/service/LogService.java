package br.com.hub.errors.service;

import br.com.hub.errors.exception.LogResourceException;
import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import br.com.hub.errors.resource.DTO.LogDTO;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
//        PageRequest pageReq
//                = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        List listLogs = logRepository.findAll();

        return listLogs;
    }

    public Optional<Log> get(UUID id) {return logRepository.findById(id);}
}
