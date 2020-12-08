package br.com.yantra.springbootapi.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Preco {
    @ApiModelProperty(value = "Código do preço")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = "Preço da tatuagem")
    @Column(nullable = false)
    private Double price;

    @ApiModelProperty(value = "Preço foi aceito?")
    @Column(nullable = false)
    private boolean accept;

    @ApiModelProperty(value = "codigo da tattoo")
    @Column(nullable = false)
    private long tattooId;

    @ApiModelProperty(value = "codigo do tatuador")
    @Column(nullable = false)
    private long tatuadorId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public long getTattooId() {
        return tattooId;
    }

    public void setTattooId(long tattooId) {
        this.tattooId = tattooId;
    }

    public long getTatuadorId() {
        return tatuadorId;
    }

    public void setTatuadorId(long tatuadorId) {
        this.tatuadorId = tatuadorId;
    }
}