package br.com.hub.errors.model;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.model.enum_model.StagesEnum;
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
    private String description;
    private LocalDate date;
    private String origin;
    private Integer frequency;
    private StagesEnum stage;

    //@ManyToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name = "userId", referencedColumnName = "id") //nullable=false
    //private User user;
}
