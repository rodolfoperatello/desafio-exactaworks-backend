package br.com.exactaworks.desafio.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(description = "Details about the LoginRequest")
public class LoginRequest {

    @NotEmpty(message = "The user's email cannot be null or empty")
    @ApiModelProperty(notes = "The user's email")
    private String email;
    @NotEmpty(message = "The user's password cannot be null or empty")
    @ApiModelProperty(notes = "The user's password")
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
