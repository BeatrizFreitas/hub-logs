package br.com.hub.errors.controller;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.dto.LogDTO;
import br.com.hub.errors.model.enum_model.EnvironmentEnum;
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Column;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    //o find_by pode ser usado para: ambiente/level/description/origin
    @GetMapping("/logs/find_by")
    @ResponseBody
    public List<LogDTO> getLogs(@RequestParam Map<String,String> allParams) {
        List<Log> logs = logService.find_by(allParams);
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

    private LogDTO convertToDto(Log log) {
        LogDTO logDto = modelMapper.map(log, LogDTO.class);
        return logDto;
    }

    private Log convertToEntity(LogDTO logDto) {
        Log log = modelMapper.map(logDto, Log.class);
        return log;
    }

}
