package br.com.hub.errors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Erro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String level;
    private String description;
    private String origin;
    private Integer frequency;
    private String colectedby;
    private Date origin_date;

    public Erro(){

    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getColectedby() {
        return colectedby;
    }

    public void setColectedby(String colectedby) {
        this.colectedby = colectedby;
    }

    public Date getOrigin_date() {
        return origin_date;
    }

    public void setOrigin_date(Date origin_date) {
        this.origin_date = origin_date;
    }

}


