package br.com.hub.errors.controller;

import br.com.hub.errors.model.Log;
import br.com.hub.errors.dto.LogDTO;
import br.com.hub.errors.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public List<LogDTO> getAllLogs(){

        List<Log> logs = logService.getAllLogs();
        return logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/logs")
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
    public List<LogDTO> getLogs(@RequestParam Map<String,String> allParams) {
        HashMap<String, String> params = getParams(allParams);

        List<Log> logs = logService.getLog(params);
        return logs.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private HashMap<String, String> getParams(Map<String, String> allParams) {
        HashMap<String, String> params = new HashMap<String, String>();
        if (allParams.get("frequency") != null){
            params.put("frequency", allParams.get("frequency"));
        } else if (allParams.get("errorLevel") != null){
            params.put("errorLevel", allParams.get("errorLevel"));
        }else if (allParams.get("date") != null){
            params.put("date", allParams.get("date"));
        }else if (allParams.get("origin") != null){
            params.put("origin", allParams.get("origin"));
        }else if (allParams.get("stage") != null){
            params.put("stage", allParams.get("stage"));
        }else {
//            TODO: INCLUIR LOG DE QUE O PARAMETRO NAO FOI ENCONTRADO
        }
        return params;
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
