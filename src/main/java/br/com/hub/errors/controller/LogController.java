package br.com.hub.errors.controller;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.dto.LogDTO;
import br.com.hub.errors.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    public List<LogDTO> getLogs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                 @RequestParam(value = "size", required = false, defaultValue = "10") int size){

        Page<Log> logs = logService.getLogsList(page, size);
        List<LogDTO> listLogdTO = logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return  listLogdTO;
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
    @ApiOperation(value = "Returns a list of logs according to the requested filters")
    public List<LogDTO> findLogs(@RequestParam Map<String,String> allParams,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                 @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        Page<Log> logs = logService.filterLogs(allParams, page, size);
        List<LogDTO> listLogdTO = logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        Page<LogDTO> pageLog = new PageImpl<>(listLogdTO);

        return pageLog.getContent();

    }

    @GetMapping("/logs/order_by")
    @ApiOperation(value = "Returns an ordered list of logs")
    public List<LogDTO> sortLogs(@RequestParam Map<String,String> allParams,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                 @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        String paramName = getParameterSort(allParams);

        Page<Log> logs = logService.sortLogs(paramName, page, size);

        List<LogDTO> listLogdTO = logs.getContent().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        Page<LogDTO> pageLog = new PageImpl<>(listLogdTO);

        return pageLog.getContent();
    }

    private LogDTO convertToDto(Log log) { return modelMapper.map(log, LogDTO.class); }

    private Log convertToEntity(LogDTO logDto) { return modelMapper.map(logDto, Log.class); }

    private static String getParameterSort(Map<String, String> params) { return params.get("order_by");}

}
