package br.com.hub.errors.test.unit;

<<<<<<< HEAD:src/main/java/br/com/hub/errors/test/unit/DtoUnitTest.java
import br.com.hub.errors.dto.LogDTO;
import br.com.hub.errors.model.Log;
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
=======
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.model.Log;
import java.util.UUID;
import br.com.hub.errors.dto.request.LogDTORequest;
import org.junit.jupiter.api.Test;
>>>>>>> develop:src/test/java/br/com/hub/errors/unit/DtoUnitTest.java
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

<<<<<<< HEAD:src/main/java/br/com/hub/errors/test/unit/DtoUnitTest.java
        LogDTO logDto = modelMapper.map(log, LogDTO.class);
        Assert.assertEquals(log.getId(), logDto.getId());
        Assert.assertEquals(log.getErrorLevel(), logDto.getErrorLevel());
        Assert.assertEquals(log.getDescription(), logDto.getDescription());
=======
        LogDTORequest logDtoRequest = modelMapper.map(log, LogDTORequest.class);
        assertEquals(log.getId(), logDtoRequest.getId());
        assertEquals(log.getErrorLevel(), logDtoRequest.getErrorLevel());
        assertEquals(log.getDescription(), logDtoRequest.getDescription());
>>>>>>> develop:src/test/java/br/com/hub/errors/unit/DtoUnitTest.java
    }

    @Test
    public void whenConvertPostDtoToPostEntity_thenCorrect() {
        LogDTORequest logDtoRequest = new LogDTORequest();
        ErrorLevelsEnum level = ErrorLevelsEnum.DEBUG;

        logDtoRequest.setId(UUID.randomUUID());
        logDtoRequest.setErrorLevel(level);
        logDtoRequest.setDescription("test");

<<<<<<< HEAD:src/main/java/br/com/hub/errors/test/unit/DtoUnitTest.java
        Log log = modelMapper.map(logDto, Log.class);
        Assert.assertEquals(logDto.getId(), log.getId());
        Assert.assertEquals(logDto.getErrorLevel(), log.getErrorLevel());
        Assert.assertEquals(logDto.getDescription(), log.getDescription());
=======
        Log log = modelMapper.map(logDtoRequest, Log.class);
        assertEquals(logDtoRequest.getId(), log.getId());
        assertEquals(logDtoRequest.getErrorLevel(), log.getErrorLevel());
        assertEquals(logDtoRequest.getDescription(), log.getDescription());
>>>>>>> develop:src/test/java/br/com/hub/errors/unit/DtoUnitTest.java
    }
}

