package br.com.yantra.springbootapi.entity;

import io.swagger.annotations.ApiModelProperty;

public class Login {
    @ApiModelProperty(value = "Login da pessoa")
    private String login;

    @ApiModelProperty(value = "Senha da pessoa")
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}