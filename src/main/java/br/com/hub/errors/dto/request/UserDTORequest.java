package br.com.hub.errors.dto.request;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserDTORequest {

    private Long id;

    @NotNull(message = "Email is a required parameter")
    @Email
    private String userEmail;

    @NotNull(message = "Password is a required parameter")
    @Size(min = 6)
    private String password;

    @NotNull(message = "Role is a required parameter")
    private String role;

    @NotNull(message = "enabled is a required parameter")
    @Column
    private String enabled;

}