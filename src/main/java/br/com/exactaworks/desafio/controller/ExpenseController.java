package br.com.exactaworks.desafio.controller;

import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.service.ExpenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/expense")
@Api(tags = {"Expense Controller"})
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    @ApiOperation(value = "Create a new expense",
        notes = "Provide an ExpenseRequest object to create an expense",
        response = ExpenseResponse.class)
    public ResponseEntity<ExpenseResponse> createExpense(@RequestBody @Valid ExpenseRequest expenseRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.expenseService.saveExpense(expenseRequest));
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Finds an expense by ID",
            notes = "Provide an ID to look up specific expense",
            response = ExpenseResponse.class)
    public ResponseEntity<ExpenseResponse> findExpenseById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findExpenseById(id));
    }

    @GetMapping
    @ApiOperation(value = "Finds all expenses registered in the data base",
            notes = "Provide additional information to get the expenses paged",
            response = ExpenseResponse.class)
    public ResponseEntity<Page<ExpenseResponse>> findAllExpenses(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findAllExpenses(pageable));
    }
}

