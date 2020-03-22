
package br.com.hub.errors.dto;

import br.com.hub.errors.model.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements UserDetails {
    private UUID id;

    @NotNull(message = "Name is a required parameter")
    @Size(min = 3)
    private String name;

    @NotNull(message = "Last Name is a required parameter")
    @Size(min = 2)
    private String lastName;

    @NotNull(message = "Email is a required parameter")
    @Email
    private String login;

    @NotNull(message = "Password is a required parameter")
    @Size(min = 8)
    private String password;

    private String token;

    public UserDTO(User user){
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}