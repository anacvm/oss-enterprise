package br.com.yantra.springbootapi.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Tattoo {
    @ApiModelProperty(value = "Código da tatuagem")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = "Estilo da tatuagem")
    @Column(nullable = false)
    private String style;

    @ApiModelProperty(value = "Local do corpo para a tatuagem")
    @Column(nullable = false)
    private String localCorpo;

    @ApiModelProperty(value = "Descricao da tatuagem")
    @Column(nullable = false)
    private String descricao;

    @ApiModelProperty(value = "URL da imagem da tatuagem")
    @Column(nullable = false)
    private String urlImagem;

    @ApiModelProperty(value = "URL2 da imagem da tatuagem")
    @Column(nullable = false)
    private String urlImagem2;

    @ApiModelProperty(value = "Id do Usuario")
    @Column(nullable = false)
    private long usersId;

    @ApiModelProperty(value = "Id do preço selecionado")
    @Column(nullable = false)
    private long precoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLocalCorpo() {
        return localCorpo;
    }

    public void setLocalCorpo(String localCorpo) {
        this.localCorpo = localCorpo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getUrlImagem2() {
        return urlImagem2;
    }

    public void setUrlImagem2(String urlImagem2) {
        this.urlImagem2 = urlImagem2;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public long getPrecoId() {
        return precoId;
    }

    public void setPrecoId(long precoId) {
        this.precoId = precoId;
    }
}