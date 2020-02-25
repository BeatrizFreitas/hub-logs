package br.com.hub.errors.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LogResource {

    @JsonProperty("id")
    private String id;
    @JsonProperty("codigo_erro")
    private String erro;
    @JsonProperty("descricao_erro")
    private String description;
    @JsonProperty("data")
    private String date;
    @JsonProperty("origem")
    private String origin;
    @JsonProperty("coletado_por")
    private String colectedby;

    public LogResource(String id, String erro, String description, String date, String origin, String colectedby) {
        this.id = id;
        this.erro = erro;
        this.description = description;
        this.date = date;
        this.origin = origin;
        this.colectedby = colectedby;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColectedby() {
        return colectedby;
    }

    public void setColectedby(String colectedby) {
        this.colectedby = colectedby;
    }

    @Override
    public String toString() {
        return "LogResource{" +
                "id='" + id + '\'' +
                ", erro='" + erro + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", origin='" + origin + '\'' +
                ", colectedby='" + colectedby + '\'' +
                '}';
    }
}
