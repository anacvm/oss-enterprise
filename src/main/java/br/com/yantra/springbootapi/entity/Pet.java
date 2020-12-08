package br.com.yantra.springbootapi.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Pet {
    @ApiModelProperty(value = "Id do pet")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = "Nome do pet")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(value = "Sobrenome do pet")
    @Column(nullable = false)
    private String sobrenome;

    @ApiModelProperty(value = "Telefone do pet")
    @Column(nullable = false)
    private String telefone;

    @ApiModelProperty(value = "Url do Icone do pet")
    @Column(nullable = false)
    private String icon_pet;

    @ApiModelProperty(value = "Tipo do pet")
    @Column(nullable = false)
    private String tipo;

    @ApiModelProperty(value = "Descrição do pet")
    @Column(nullable = false)
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIcon_user() {
        return icon_user;
    }

    public void setIcon_user(String icon_user) {
        this.icon_user = icon_user;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}