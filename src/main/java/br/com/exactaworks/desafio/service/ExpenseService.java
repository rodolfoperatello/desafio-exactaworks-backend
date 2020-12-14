package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.repository.ExpenseRepository;

public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

}
