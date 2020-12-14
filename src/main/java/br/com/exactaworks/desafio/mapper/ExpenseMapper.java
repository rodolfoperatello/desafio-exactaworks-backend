package br.com.exactaworks.desafio.mapper;

import br.com.exactaworks.desafio.builder.request.ExpenseBuilderEntity;
import br.com.exactaworks.desafio.builder.response.ExpenseBuilderResponse;
import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.entity.ExpenseEntity;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public static ExpenseEntity convertToEntity(ExpenseRequest expenseRequest){
        return new ExpenseBuilderEntity()
                .withName(expenseRequest.getName())
                .withDescription(expenseRequest.getDescription())
                .withValue(expenseRequest.getValue())
                .build();
    }

    public static ExpenseResponse convertToResponse(ExpenseEntity expenseEntity){
        return new ExpenseBuilderResponse()
                .withId(expenseEntity.getId())
                .withName(expenseEntity.getName())
                .withDescription(expenseEntity.getDescription())
                .withLocalDateTime(expenseEntity.getDateTime())
                .withValue(expenseEntity.getValue())
                .withTag(expenseEntity.getTag())
                .build();
    }
}
