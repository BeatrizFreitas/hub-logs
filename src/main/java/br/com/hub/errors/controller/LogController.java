package br.com.hub.errors.controller;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.dto.request.LogDTORequest;
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
    public List<LogDTORequest> getLogs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                       @RequestParam(value = "size", required = false, defaultValue = "10") int size){

        Page<Log> logs = logService.getLogsList(page, size);
        List<LogDTORequest> listLogdTO = logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return  listLogdTO;
    }

    @PostMapping("/logs")
    @ApiOperation(value = "Creates a new log")
    @ApiResponse(code = 201, message = "LOG SAVED SUCCESSFULLY", response = LogDTORequest.class)
    @ResponseStatus(HttpStatus.CREATED)
    public LogDTORequest saveLog(@Valid @RequestBody LogDTORequest logDtoRequest){
        Log log = convertToEntity(logDtoRequest);
        System.out.println("AQUIII"+log);

        Log logCreated = logService.registerLog(log);
        return convertToDto(logCreated);
    }

    @GetMapping("/logs/find_by")
    @ApiOperation(value = "Returns a list of logs according to the requested filters")
    public List<LogDTORequest> findLogs(@RequestParam Map<String,String> allParams,
                                        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                        @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        Page<Log> logs = logService.filterLogs(allParams, page, size);
        List<LogDTORequest> listLogdTO = logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        Page<LogDTORequest> pageLog = new PageImpl<>(listLogdTO);

        return pageLog.getContent();

    }

    @GetMapping("/logs/order_by")
    @ApiOperation(value = "Returns an ordered list of logs")
    public List<LogDTORequest> sortLogs(@RequestParam Map<String,String> allParams,
                                        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                        @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        String paramName = getParameterSort(allParams);

        Page<Log> logs = logService.sortLogs(paramName, page, size);

        List<LogDTORequest> listLogdTO = logs.getContent().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        Page<LogDTORequest> pageLog = new PageImpl<>(listLogdTO);

        return pageLog.getContent();
    }

    private LogDTORequest convertToDto(Log log) { return modelMapper.map(log, LogDTORequest.class); }

    private Log convertToEntity(LogDTORequest logDtoRequest) { return modelMapper.map(logDtoRequest, Log.class); }

    private static String getParameterSort(Map<String, String> params) { return params.get("order_by");}

}
