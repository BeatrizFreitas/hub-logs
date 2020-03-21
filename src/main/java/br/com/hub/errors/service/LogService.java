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
        try{
            log = logRepository.save(log);
            LOG.info("Log saved successfully");
            LOG.info(log);
        } catch (Exception e){
            LOG.error(e);
        }
        return log;
    }

    public List<Log> getLogsList(){
        List<Log> listLogs = null;
        try {
            listLogs = logRepository.findAll();
            LOG.info("Search performed");
            LOG.info(listLogs);
        } catch (Exception e){
            LOG.error(e);
        }
        return listLogs;
    }


    public List<Log> findAllFilters(Map<String, String> allParams) {
        List<Log> listLog = null;
        try{
            listLog = logRepository.findAll(LogSpecs.getLogsByFilters(allParams));
        } catch (Exception e){
            LOG.error(e);
        }
        return listLog;
    }

}
