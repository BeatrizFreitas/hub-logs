package br.com.hub.errors.model;

import br.com.hub.errors.model.enum_model.EnvironmentEnum;
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column
    private ErrorLevelsEnum errorLevel;
    @Column
    private String description;
    @Column
    @DateTimeFormat
    private LocalDate date;
    @Column
    private String origin;
    @Column
    private Integer frequency;
    @Column
    private EnvironmentEnum stage;

   // @ManyToOne
   // @JoinColumn(name="user_id")
   // private User user;
}
