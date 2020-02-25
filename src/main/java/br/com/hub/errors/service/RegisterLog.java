package br.com.hub.errors.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hub.errors.exception.LogResourceException;
import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import br.com.hub.errors.resource.model.LogResource;


@Service
public class RegisterLog {
    private static final Logger LOG = Logger.getLogger(RegisterLog.class);
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private LogConversor service;

    public void registerLog(LogResource logResource) {
        try{
            Log log = service.conversor(logResource);
            logRepository.saveAndFlush(log);
        } catch(LogResourceException e){
            LOG.error("Erro ao salvar o Log" + e.getMessage(), e);
        }
    }
}
