package br.com.hub.errors.controller;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.repository.LogRepository;
import br.com.hub.errors.resource.model.LogResource;
import br.com.hub.errors.service.ManageLog;
import br.com.hub.errors.service.RegisterLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")

public class LogController {
    @Autowired
    LogRepository logRepository;

    @Autowired
    private ManageLog serviceManage;

    @Autowired
    private RegisterLog serviceRegister;

    @GetMapping("/logs")
    public List<Log> listLog(){
        return serviceManage.findAllLog();
    }

    @PostMapping("/log")
    public void saveLog(@RequestBody LogResource log){
        serviceRegister.registerLog(log);
    }

}
