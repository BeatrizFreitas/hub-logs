package br.com.hub.errors.model;

import br.com.hub.errors.model.enum_model.EnvironmentsEnum;
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LOG")
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
    private LocalDate date;
    @Column
    private String origin;
    @Column
    private EnvironmentsEnum environment;
}
