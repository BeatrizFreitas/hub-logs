package br.com.hub.errors.service;

import org.springframework.stereotype.Component;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.exception.LogResourceException;
import br.com.hub.errors.resource.model.LogResource;


import java.time.LocalDate;

@Component
// usei o component para identifica-lo como nao-serviço - ele é utilizado pelo serviço -

public class LogConversor {
    public Log conversor(LogResource logResource) throws LogResourceException {
        try{
            Log log = new Log();

            LocalDate date  = checkData(logResource.getDate());

            log.setDate(date);
            log.setColectedby(logResource.getColectedby());
            log.setDescription(logResource.getDescription());
            log.setErro(logResource.getErro());
            log.setOrigin(logResource.getOrigin());

            return log;

        } catch (Exception e) {
            throw new LogResourceException("Falha ao converter o resource para entidade, resource: " + logResource);
        }

    }

    private LocalDate checkData(String date){
        return LocalDate.parse(date);
    }

}
