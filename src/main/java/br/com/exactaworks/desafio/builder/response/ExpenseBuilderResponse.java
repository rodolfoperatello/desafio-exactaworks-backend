package br.com.exactaworks.desafio.builder.response;

import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseBuilderResponse {

    private final ExpenseResponse expenseResponse;

    public ExpenseBuilderResponse(){
        this.expenseResponse = new ExpenseResponse();
    }

    public ExpenseBuilderResponse withId(Long id){
        this.expenseResponse.setId(id);
        return this;
    }

    public ExpenseBuilderResponse withName(String name){
        this.expenseResponse.setName(name);
        return this;
    }

    public ExpenseBuilderResponse withDescription(String description){
        this.expenseResponse.setDescription(description);
        return this;
    }

    public ExpenseBuilderResponse withValue(BigDecimal value) {
        this.expenseResponse.setValue(value);
        return this;
    }

    public ExpenseBuilderResponse withLocalDateTime(LocalDateTime localDateTime){
        this.expenseResponse.setDateTime(localDateTime);
        return this;
    }

    public ExpenseBuilderResponse withTag(String tag){
        this.expenseResponse.setTag(tag);
        return this;
    }

    public ExpenseResponse build(){
        return this.expenseResponse;
    }
}
