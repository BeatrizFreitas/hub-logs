package br.com.hub.errors.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTOResponse {

    private Long id;
    private String userEmail;
    private String role;

}

