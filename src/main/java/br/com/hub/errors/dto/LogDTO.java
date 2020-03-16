package br.com.hub.errors.dto;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
public class LogDTO {

    private UUID id;
    @NotNull
    private ErrorLevelsEnum errorLevel;
    @NotNull
    private String description;

}
