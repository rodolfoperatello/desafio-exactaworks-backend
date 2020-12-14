package br.com.exactaworks.desafio.controller;

import br.com.exactaworks.desafio.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody @Validated ExpenseRequest expenseRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.expenseService.saveExpense(expenseRequest));
    }

}
