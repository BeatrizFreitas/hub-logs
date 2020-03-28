package br.com.hub.errors.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Email
    private String userEmail;
    @Column
    private String name;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column
    private String role;
    @Column
    private short enabled;

    public User(Integer id, String name, String userEmail, String role) {
        this.id = id;
        this.name = name;
        this.userEmail = userEmail;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("UserInfo [id=%s, userEmail=%s, password=%s, role=%s, enabled=%s]", id, userEmail, password, enabled);
    }

}