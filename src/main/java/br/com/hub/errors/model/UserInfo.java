package br.com.hub.errors.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserInfo implements Serializable {
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
    private String role;
    @Column
    private short enabled;

    @Override
    public String toString() {
        return String.format("UserInfo [id=%s, userEmail=%s, password=%s, role=%s, enabled=%s]", id, userEmail, password,
                role, enabled);
    }

}