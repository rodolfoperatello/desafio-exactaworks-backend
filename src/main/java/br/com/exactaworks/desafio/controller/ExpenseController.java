package br.com.exactaworks.desafio.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/expense")
public class ExpenseController {

    public createExpense(@RequestBody @Validated ExpenseR)


}
