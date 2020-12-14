package br.com.exactaworks.desafio.builder.request;

import br.com.exactaworks.desafio.entity.ExpenseEntity;

import java.math.BigDecimal;

public class ExpenseBuilderEntity {

    private final ExpenseEntity expenseEntity;

    public ExpenseBuilderEntity(){
        this.expenseEntity = new ExpenseEntity();
    }

    public ExpenseBuilderEntity withName(String name){
        this.expenseEntity.setName(name);
        return this;
    }

    public ExpenseBuilderEntity withDescription(String description){
        this.expenseEntity.setDescription(description);
        return this;
    }

    public ExpenseBuilderEntity withValue(BigDecimal value){
        this.expenseEntity.setValue(value);
        return this;
    }

    public ExpenseEntity build(){
        return this.expenseEntity;
    }
}

