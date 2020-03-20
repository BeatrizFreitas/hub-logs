package br.com.hub.errors.dto;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.model.enum_model.EnvironmentEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class LogDTO {

    private UUID id;
    @NotNull
    private ErrorLevelsEnum errorLevel;
    @NotNull
    private String description;
    @Column
    private LocalDate date;
    @Column
    private String origin;
    @Column
    private Integer frequency;
    @Column
    private EnvironmentEnum environment;

}
