package br.com.hub.errors.service;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import br.com.hub.errors.specification.LogSpecs;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

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

    public Page<Log> getLogsList(int page, int size){
        Page<Log> pageResult = null;
        try {
            Pageable paging = PageRequest.of(page, size);
            pageResult = logRepository.findAll(paging);
            LOG.info("Search performed");
            LOG.info(pageResult);
        } catch (Exception e){
            LOG.error(e);
        }
        return pageResult;
    }

    public Page<Log> filterLogs(Map<String, String> params, int page, int size) {
        Page<Log> pageResult = null;
        try{
            LOG.info("Getting logs with parameters");
            Pageable paging = PageRequest.of(page, size);
            pageResult = logRepository.findAll(LogSpecs.getLogsByFilters(params), paging);
            LOG.info("Logs retrivied" + pageResult);
        } catch (Exception e){
            LOG.error(e);
        }
        return pageResult;
    }

    public Page<Log> sortLogs(String param, int page, int size) {
        Page<Log> pageResult = null;
        try{
            LOG.info("Order logs by parameter:" + param);
            Pageable paging = PageRequest.of(page, size, Sort.by(param).ascending());
            pageResult = logRepository.findAll(paging);
            LOG.info("Logs retrivied" + pageResult);
        } catch (Exception e){
            LOG.error(e);
        }

        return pageResult;
    }


}
