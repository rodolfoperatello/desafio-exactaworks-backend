package br.com.exactaworks.desafio.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel(description = "Details about the ExpenseRequest")
public class ExpenseRequest {

    @NotBlank(message = "The user's name cannot be null or empty")
    @Email(message = "Inform a valid email. Ex: user@email.com")
    @ApiModelProperty(notes = "The person's name")
    private String name;
    @NotBlank(message = "The expense's description cannot be null or empty")
    @ApiModelProperty(notes = "The expense's description")
    private String description;
    @NotNull(message = "The expense's value cannot be null or empty")
    @Min(value = 0, message = "The expense's value cannot be less than zero")
    @ApiModelProperty(notes = "The expense's value")
    private BigDecimal value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
