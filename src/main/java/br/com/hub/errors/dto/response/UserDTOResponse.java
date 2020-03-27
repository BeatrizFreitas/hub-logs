package br.com.hub.errors.dto.response;

import br.com.hub.errors.model.enum_model.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTOResponse {

    private Long id;
    private String userEmail;
    private RoleEnum role;

}

