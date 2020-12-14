package br.com.exactaworks.desafio.builder;

import br.com.exactaworks.desafio.entity.ExpenseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseBuilder {

    private final ExpenseEntity expenseEntity;

    public ExpenseBuilder(){
        this.expenseEntity = new ExpenseEntity();
    }

    public ExpenseBuilder withId(Long id){
        this.expenseEntity.setId(id);
        return this;
    }

    public ExpenseBuilder withName(String name){
        this.expenseEntity.setName(name);
        return this;
    }

    public ExpenseBuilder withDescription(String description){
        this.expenseEntity.setDescription(description);
        return this;
    }

    public ExpenseBuilder withDateTime(LocalDateTime dateTime){
        this.expenseEntity.setDateTime(dateTime);
        return this;
    }

    public ExpenseBuilder withValue(BigDecimal value){
        this.expenseEntity.setValue(value);
        return this;
    }

    public ExpenseBuilder withTag(String tag){
        this.expenseEntity.setTag(tag);
        return this;
    }

    public ExpenseEntity build(){
        return this.expenseEntity;
    }
}

