package br.com.hub.errors.resource.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class LogDTO {

    private String id;
    @NotNull
    private String errorCode;
    @NotNull
    private String description;

}
