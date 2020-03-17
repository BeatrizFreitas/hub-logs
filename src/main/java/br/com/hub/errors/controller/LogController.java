package br.com.hub.errors.controller;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.dto.LogDTO;
import br.com.hub.errors.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api")
@Api(value = "Central de Erros")
@CrossOrigin(origins = "*") //O * libera para que qualquer domínio possa acessar a API
public class LogController {
    @Autowired
    private LogService logService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/logs")
    @ApiOperation(value = "Retorna uma lista de Logs")
    @ResponseBody
    public List<LogDTO> getLogs(){

        List<Log> logs = logService.getLogsList();
        return logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/log")
    @ApiOperation(value = "Cria um novo Log")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public LogDTO saveLog(@Valid @RequestBody LogDTO logDto){
        Log log = convertToEntity(logDto);
        Log logCreated = logService.registerLog(log);
        return convertToDto(logCreated);
    }

    @GetMapping("/logs/find_by")
    @ResponseBody
    public Page<Log> findLogs(@And({
            @Spec(path = "errorLevel", spec = Like.class),
            @Spec(path = "origin", spec = Like.class),
            @Spec(path = "stage", spec = Like.class)
    }) Specification<Log> LogSpec,
                              Pageable pageable) {

        return logService.findAll(LogSpec, pageable);
    }

    private LogDTO convertToDto(Log log) {
        LogDTO logDto = modelMapper.map(log, LogDTO.class);
        return logDto;
    }

    private Log convertToEntity(LogDTO logDto) {
        Log log = modelMapper.map(logDto, Log.class);
        return log;
    }

}
