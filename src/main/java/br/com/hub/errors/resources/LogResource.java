package br.com.hub.errors.resources;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")

public class LogResource {
    @Autowired
    LogRepository logRepository;

    @GetMapping("/logs")
    public List<Log> listLog(){
        return logRepository.findAll();
    }

    @GetMapping("/log/{id}")
    public Log listLogUniq(@PathVariable(value="id") long id){
        return logRepository.findById(id);
    }

    @PostMapping("/log")
    public void saveLog(@RequestBody Log log){
        logRepository.save(log);
    }

}
