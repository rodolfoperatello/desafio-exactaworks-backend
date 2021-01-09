package br.com.exactaworks.desafio.builder.request;

import br.com.exactaworks.desafio.entity.ExpenseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseBuilderEntity {

    private final ExpenseEntity expenseEntity;

    public ExpenseBuilderEntity(){
        this.expenseEntity = new ExpenseEntity();
    }

    public ExpenseBuilderEntity withDescription(String description){
        this.expenseEntity.setDescription(description);
        return this;
    }

    public ExpenseBuilderEntity withValue(BigDecimal value){
        this.expenseEntity.setValue(value);
        return this;
    }


    public ExpenseBuilderEntity withTag(String tag){
        this.expenseEntity.setTag(tag);
        return this;
    }

    public ExpenseBuilderEntity withDateTime(String dateTime){
        this.expenseEntity.setDateTime(LocalDateTime.parse(dateTime));
        return this;
    }

    public ExpenseEntity build(){
        return this.expenseEntity;
    }
}

