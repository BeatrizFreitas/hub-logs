package br.com.hub.errors.service;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageLog {
    @Autowired
    private LogRepository logRepository;

    public List<Log> findAllLog(){
        List<Log> listLog = logRepository.findAll();
        return listLog;
    }

    public Optional<Log> get(Long id) {return logRepository.findById(id);}
}
