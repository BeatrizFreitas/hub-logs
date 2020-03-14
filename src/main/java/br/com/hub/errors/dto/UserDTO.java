package br.com.hub.errors.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Size(min = 2)
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    //TODO:Verificar se/por que precisa ter no DTO
    //private String token;
}
