package br.com.hub.errors.controller;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.dto.LogDTO;
import br.com.hub.errors.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/api")
@Api(value = "Central de Erros")
public class LogController {
    @Autowired
    private LogService logService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/logs")
    @ApiOperation(value = "Returns a list of logs")
    @ResponseBody
    public List<LogDTO> getLogs(){

        List<Log> logs = logService.getLogsList();
        return logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/logs")
    @ApiOperation(value = "Creates a new log")
    @ApiResponse(code = 201, message = "Log salvo com sucesso", response = LogDTO.class)
    @ResponseStatus(HttpStatus.CREATED)
    public LogDTO saveLog(@Valid @RequestBody LogDTO logDto){
        Log log = convertToEntity(logDto);
        Log logCreated = logService.registerLog(log);
        return convertToDto(logCreated);
    }

    @GetMapping("/logs/find_by")
    @ApiOperation(value = "Return a list of logs according to the requested filters")
    public List<LogDTO> findLogs(@RequestParam Map<String,String> allParams) {
        List<Log> logs = logService.findAllFilters(allParams);
        return logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
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
