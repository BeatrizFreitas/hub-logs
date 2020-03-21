package br.com.hub.errors.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private UUID id;

    @NotNull(message = "Name is a required parameter")
    @Size(min = 3)
    private String name;

    @NotNull(message = "Last Name is a required parameter")
    @Size(min = 2)
    private String lastName;

    @NotNull(message = "Email is a required parameter")
    @Email
    private String email;

    @NotNull(message = "Password is a required parameter")
    @Size(min = 8)
    private String password;

    private String token;
}
