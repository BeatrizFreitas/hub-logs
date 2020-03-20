package br.com.hub.errors.service;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LogService {
    private static final Logger LOG = Logger.getLogger(LogService.class);
    @Autowired
    private LogRepository logRepository;

    public Log registerLog(Log log) {
        return logRepository.save(log);
    }

    public List<Log> getAllLogs(){
        List listLogs = logRepository.findAll();
        return listLogs;
    }

    public List<Log> getLog(HashMap<String, String> params) {
        StringBuilder newQuery = generateQuery(params);
        List listLogs = logRepository.find_by(newQuery);
        return listLogs;
    }

    private StringBuilder generateQuery(HashMap<String, String> params) {
        StringBuilder sql = new StringBuilder();
        final int[] aux = {0};

        sql.append("SELECT * FROM TABLE");
        if(params != null) {
            sql.append(" WHERE ");
            params.forEach((k,v)->{
                if (aux[0] != 0){
                    sql.append(" AND " + k + " = " + v);
                } else {
                    sql.append(k + " = " + v);
                    aux[0] = 1;
                }
            });
        }
        return sql;
    }

}
