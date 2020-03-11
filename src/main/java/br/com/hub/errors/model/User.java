package br.com.hub.errors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    @Email
    private String email;
    @Column
    private String password;
    @Column
    private String token;

    //@OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL)
    //private List<Log> logs;
}