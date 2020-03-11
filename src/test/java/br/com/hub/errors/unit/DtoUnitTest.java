package br.com.hub.errors.unit;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.model.Log;
import java.util.UUID;
import br.com.hub.errors.dto.LogDTO;
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

        LogDTO logDto = modelMapper.map(log, LogDTO.class);
        assertEquals(log.getId(), logDto.getId());
        assertEquals(log.getErrorLevel(), logDto.getErrorLevel());
        assertEquals(log.getDescription(), logDto.getDescription());
    }

    @Test
    public void whenConvertPostDtoToPostEntity_thenCorrect() {
        LogDTO logDto = new LogDTO();
        ErrorLevelsEnum level = ErrorLevelsEnum.DEBUG;

        logDto.setId(UUID.randomUUID());
        logDto.setErrorLevel(level);
        logDto.setDescription("test");

        Log log = modelMapper.map(logDto, Log.class);
        assertEquals(logDto.getId(), log.getId());
        assertEquals(logDto.getErrorLevel(), log.getErrorLevel());
        assertEquals(logDto.getDescription(), log.getDescription());
    }
}

