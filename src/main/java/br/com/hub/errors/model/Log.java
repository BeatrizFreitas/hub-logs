package br.com.hub.errors.model;

import br.com.hub.errors.model.Enum.ErrorLevelsEnum;
import br.com.hub.errors.model.Enum.StagesEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_LOG")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private ErrorLevelsEnum errorLevel;
    private String description;
    private LocalDate date;
    private String origin;
    private int frequency;
    private StagesEnum stage;
    private String userName;

    /*@OneToOne
    private User user;*/
}
