package br.com.exactaworks.desafio.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ExpenseRequest {

    @NotBlank(message = "O nome do usuário não pode ser nulo ou em branco")
    private String name;
    @NotBlank(message = "A descrição da despesa não pode ser nulo ou em branco")
    private String description;
    @NotNull(message = "O valor da despesa não pode ser nulo")
    private BigDecimal value;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
