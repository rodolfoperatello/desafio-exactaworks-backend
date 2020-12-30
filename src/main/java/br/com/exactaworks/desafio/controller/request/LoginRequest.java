package br.com.exactaworks.desafio.controller.request;

import javax.validation.constraints.NotEmpty;

public class LoginRequest {

    @NotEmpty(message = "O email não pode ser nulo ou vazio")
    private String email;
    @NotEmpty(message = "A senha não pode ser nulo ou vazio")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
