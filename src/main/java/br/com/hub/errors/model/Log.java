package br.com.hub.errors.model;

import br.com.hub.errors.model.Enum.ErrorLevelsEnum;
import br.com.hub.errors.model.Enum.StagesEnum;
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

    @Column(name = "errorLevel")
    private ErrorLevelsEnum errorLevel;

    @Column
    private String description;

    @Column
    private LocalDate date;

    @Column
    private String origin;

    @Column
    private Integer frequency;

    @Column
    private StagesEnum stage;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id") //nullable=false
    private User user;
}
