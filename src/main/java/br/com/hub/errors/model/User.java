package br.com.hub.errors.model;

import br.com.hub.errors.model.enum_model.RoleEnum;
import lombok.*;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @Email
    private String userEmail;
    @Column
    private String password;
    @Column
    private RoleEnum role;
    @Column
    private short enabled;

    @Override
    public String toString() {
        return String.format("UserInfo [id=%s, userEmail=%s, password=%s, role=%s, enabled=%s]", id, userEmail, password, enabled);
    }

}