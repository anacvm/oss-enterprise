package br.com.yantra.springbootapi.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Portifolio {
    @ApiModelProperty(value = "Código do portifólio")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = "Desenho do tatuador")
    @Column(nullable = false)
    private String media;

    @ApiModelProperty(value = "Local do corpo para a tatuagem")
    @Column(nullable = false)
    private long tatuadorId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public long getTatuadorId() {
        return tatuadorId;
    }

    public void setTatuadorId(long tatuadorId) {
        this.tatuadorId = tatuadorId;
    }
}