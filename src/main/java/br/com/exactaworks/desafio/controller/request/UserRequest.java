package br.com.exactaworks.desafio.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ApiModel(description = "Details about the UserRequest")
public class UserRequest {

    @NotBlank(message = "The user's email cannot be null or empty")
    @Email(message = "Inform a valid email. Example: email@email.com.br")
    @ApiModelProperty(value = "The user's email")
    private String email;
    @NotBlank(message = "The user's name cannot be null or empty")
    @ApiModelProperty(value = "The user's name")
    private String fisrtName;
    @NotBlank(message = "The user's last name cannot be null or empty")
    @ApiModelProperty(value = "The user's last name")
    private String lastName;
    @NotBlank(message = "The user's password cannot be null or empty")
    @ApiModelProperty(value = "The user's password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
