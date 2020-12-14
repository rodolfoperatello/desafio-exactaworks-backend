package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.mapper.ExpenseMapper;
import br.com.exactaworks.desafio.repository.ExpenseRepository;

public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseResponse saveExpense(ExpenseRequest expenseRequest) {
        return ExpenseMapper.convertToResponse(this.expenseRepository.save(ExpenseMapper.convertToEntity(expenseRequest)));
    }
}
