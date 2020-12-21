package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.exception.GenericException;
import br.com.exactaworks.desafio.mapper.ExpenseMapper;
import br.com.exactaworks.desafio.repository.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseResponse saveExpense(ExpenseRequest expenseRequest) {
        return ExpenseMapper.convertToResponse(this.expenseRepository.save(ExpenseMapper.convertToEntity(expenseRequest)));
    }

    public ExpenseResponse findExpenseById(Long id) {
        return ExpenseMapper.convertToResponse(this.expenseRepository
                .findById(id).orElseThrow(() -> new GenericException("despesa não encontrada")));
    }

    public Page<ExpenseResponse> findAllExpenses(Pageable pageable) {
        return ExpenseMapper.convertToPageResponse(this.expenseRepository.findAll(pageable));
    }
}
