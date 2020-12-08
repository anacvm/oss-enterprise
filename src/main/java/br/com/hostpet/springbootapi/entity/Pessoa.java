package br.com.hostpet.springbootapi.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Pessoa {
    @ApiModelProperty(value = "Código da pessoa")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = "E-mail da pessoa")
    @Column(nullable = false)
    private String email;

    @ApiModelProperty(value = "Nome da pessoa")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(value = "Sobrenome da pessoa")
    @Column(nullable = false)
    private String sobrenome;

    @ApiModelProperty(value = "Senha da pessoa")
    @Column(nullable = false)
    private String senha;

    @ApiModelProperty(value = "Telefone da pessoa")
    @Column(nullable = false)
    private String telefone;

    @ApiModelProperty(value = "Url do Icone da pessoa")
    @Column(nullable = false)
    private String icon_user;

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

    public String getIcon_user() {
        return icon_user;
    }

    public void setIcon_user(String icon_user) {
        this.icon_user = icon_user;
    }
}