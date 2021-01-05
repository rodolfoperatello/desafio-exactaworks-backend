package br.com.exactaworks.desafio.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about UserResponse")
public class UserResponse {

    @ApiModelProperty(value = "The user's full name")
    private String fullName;
    @ApiModelProperty(value = "The user's email")
    private String email;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
