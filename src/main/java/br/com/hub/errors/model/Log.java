package br.com.hub.errors.model;

import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.model.enum_model.StagesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LOG")
@FilterDef(name = "tenantFilter", parameters = {@ParamDef(name = "tenantId", type = "string")})
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
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
    private Integer frequency;
    @Column
    private StagesEnum stage;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id") //nullable=false
    private User user;
}
