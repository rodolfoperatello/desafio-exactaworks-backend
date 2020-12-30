package br.com.exactaworks.desafio.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ExpenseRequest {

    @NotBlank(message = "O nome do usuário não pode ser nulo ou em branco")
    @Email(message = "Informar um email válido Ex: user@email.com")
    private String name;
    @NotBlank(message = "A descrição da despesa não pode ser nulo ou em branco")
    private String description;
    @NotNull(message = "O valor da despesa não pode ser nulo")
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
