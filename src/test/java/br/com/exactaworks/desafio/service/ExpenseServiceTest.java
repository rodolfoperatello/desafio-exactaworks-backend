package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class ExpenseServiceTest {

    @Autowired
    private ExpenseService expenseService;
    private ExpenseRequest expenseRequest;
    private String localDateTime = LocalDateTime.now().toString();

    @BeforeEach
    public void setUp(){
        this.expenseRequest = new ExpenseRequest();
        this.expenseRequest.setUserId(1L);
        this.expenseRequest.setDescription("Pagamento almoço");
        this.expenseRequest.setDateTime(localDateTime);
        this.expenseRequest.setTag("Refeição");
        this.expenseRequest.setValue(BigDecimal.valueOf(80));
    }

    @Test
    public void createExpenseSucessful(){
        var expense = this.expenseService.saveExpense(this.expenseRequest);

        Assertions.assertNotNull(expense);
        Assertions.assertEquals(ExpenseResponse.class, expense.getClass());
        Assertions.assertEquals(5L, expense.getId());
        Assertions.assertEquals("Pagamento almoço", expense.getDescription());
        Assertions.assertEquals(BigDecimal.valueOf(80), expense.getValue());
        Assertions.assertEquals("Refeição", expense.getTag());
        Assertions.assertEquals(LocalDateTime.parse(localDateTime), expense.getDateTime());
        Assertions.assertEquals("Pedro Silva", expense.getFullName());
    }

}