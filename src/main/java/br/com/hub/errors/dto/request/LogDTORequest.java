package br.com.hub.errors.dto.request;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.model.enum_model.EnvironmentsEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class LogDTORequest {

    private UUID id;

    @NotNull(message = "Error level is a required parameter (DEBUG, WARNING, ERROR)")
    private ErrorLevelsEnum errorLevel;

    @NotNull(message = "Description is a required parameter")
    private String description;

    @NotNull(message = "Date is a required parameter")
    @Column
    @DateTimeFormat
    private LocalDate date;

    @Column
    @Size(max = 20)
    private String origin;

    @NotNull(message = "Environment not informed (DEVELOPMENT, PRODUCTION, HOMOLOGATION")
    @Column
    private EnvironmentsEnum environment;

}
