package br.com.hub.errors.unit;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.model.Log;
import java.util.UUID;
import br.com.hub.errors.dto.request.LogDTORequest;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DtoUnitTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertPostEntityToPostDto_thenCorrect() {
        Log log = new Log();
        ErrorLevelsEnum level = ErrorLevelsEnum.DEBUG;

        log.setId(UUID.randomUUID());
        log.setErrorLevel(level);
        log.setDescription("teste");

        LogDTORequest logDtoRequest = modelMapper.map(log, LogDTORequest.class);
        assertEquals(log.getId(), logDtoRequest.getId());
        assertEquals(log.getErrorLevel(), logDtoRequest.getErrorLevel());
        assertEquals(log.getDescription(), logDtoRequest.getDescription());
    }

    @Test
    public void whenConvertPostDtoToPostEntity_thenCorrect() {
        LogDTORequest logDtoRequest = new LogDTORequest();
        ErrorLevelsEnum level = ErrorLevelsEnum.DEBUG;

        logDtoRequest.setId(UUID.randomUUID());
        logDtoRequest.setErrorLevel(level);
        logDtoRequest.setDescription("test");

        Log log = modelMapper.map(logDtoRequest, Log.class);
        assertEquals(logDtoRequest.getId(), log.getId());
        assertEquals(logDtoRequest.getErrorLevel(), log.getErrorLevel());
        assertEquals(logDtoRequest.getDescription(), log.getDescription());
    }
}

