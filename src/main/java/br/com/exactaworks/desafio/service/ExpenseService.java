package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.entity.ExpenseEntity;
import br.com.exactaworks.desafio.exceptions.exception.NotFoundException;
import br.com.exactaworks.desafio.mapper.ExpenseMapper;
import br.com.exactaworks.desafio.repository.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    public ExpenseService(ExpenseRepository expenseRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.userService = userService;
    }

    public ExpenseResponse saveExpense(ExpenseRequest expenseRequest) {
        return ExpenseMapper.convertToResponse(this.expenseRepository.save(createExpenseEntity(expenseRequest)));
    }

    public ExpenseResponse findExpenseById(Long id) {
        return ExpenseMapper.convertToResponse(this.expenseRepository
                .findById(id).orElseThrow(() -> new NotFoundException("Despesa não encontrada")));
    }

    public Page<ExpenseResponse> findAllExpenses(Pageable pageable) {
        return ExpenseMapper.convertToPageResponse(this.expenseRepository.findAll(pageable));
    }
    private ExpenseEntity createExpenseEntity (ExpenseRequest expenseRequest){
        var user = this.userService.findUserEntityById(expenseRequest.getUserId());

        var expenseEntity = ExpenseMapper.convertToEntity(expenseRequest);
        expenseEntity.setUserEntity(user);

        return expenseEntity;
    }
}
