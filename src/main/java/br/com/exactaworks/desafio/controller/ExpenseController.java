package br.com.exactaworks.desafio.controller;

import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody @Validated ExpenseRequest expenseRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.expenseService.saveExpense(expenseRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExpenseResponse> findExpenseById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findExpenseById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ExpenseResponse>> findAllExpenses(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findAllExpenses(pageable));
    }
}
