package br.com.yantra.springbootapi.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Tatuador {
    @ApiModelProperty(value = "Código do tatuador")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = "E-mail do tatuador")
    @Column(nullable = false)
    private String email;

    @ApiModelProperty(value = "Nome do tatuador")
    @Column(nullable = false)
    private String nomeTatuador;

    @ApiModelProperty(value = "Sobrenome do tatuador")
    @Column(nullable = false)
    private String sobrenomeTatuador;

    @ApiModelProperty(value = "Senha do tatuador")
    @Column(nullable = false)
    private String senha;

    @ApiModelProperty(value = "Telefone do tatuador")
    @Column(nullable = false)
    private String telefone;

    @ApiModelProperty(value = "Quantidade de likes do tatuador")
    @Column(nullable = false)
    private String qtdLikes;

    @ApiModelProperty(value = "Quantidades de tattoo feitas pelo tatuador")
    @Column(nullable = false)
    private String qtdTattoo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeTatuador() {
        return nomeTatuador;
    }

    public void setNomeTatuador(String nomeTatuador) {
        this.nomeTatuador = nomeTatuador;
    }

    public String getSobrenomeTatuador() {
        return sobrenomeTatuador;
    }

    public void setSobrenomeTatuador(String sobrenomeTatuador) {
        this.sobrenomeTatuador = sobrenomeTatuador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getQtdLikes() {
        return qtdLikes;
    }

    public void setQtdLikes(String qtdLikes) {
        this.qtdLikes = qtdLikes;
    }

    public String getQtdTattoo() {
        return qtdTattoo;
    }

    public void setQtdTattoo(String qtdTattoo) {
        this.qtdTattoo = qtdTattoo;
    }
}