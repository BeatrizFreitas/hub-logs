package br.com.hub.errors.test.unit;

import br.com.hub.errors.dto.LogDTO;
import br.com.hub.errors.model.Log;
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import org.modelmapper.ModelMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;


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
        Assert.assertEquals(log.getId(), logDto.getId());
        Assert.assertEquals(log.getErrorLevel(), logDto.getErrorLevel());
        Assert.assertEquals(log.getDescription(), logDto.getDescription());
    }

    @Test
    public void whenConvertPostDtoToPostEntity_thenCorrect() {
        LogDTO logDto = new LogDTO();
        ErrorLevelsEnum level = ErrorLevelsEnum.DEBUG;

        logDto.setId(UUID.randomUUID());
        logDto.setErrorLevel(level);
        logDto.setDescription("test");

        Log log = modelMapper.map(logDto, Log.class);
        Assert.assertEquals(logDto.getId(), log.getId());
        Assert.assertEquals(logDto.getErrorLevel(), log.getErrorLevel());
        Assert.assertEquals(logDto.getDescription(), log.getDescription());
    }
}

