package br.com.hub.errors.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_LOG")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String errorCode;
//    private String errorLevel;
    private String description;
    private LocalDate date;
    private String origin;
    private int frequency;
    private String stage;
    private String userName;
}
