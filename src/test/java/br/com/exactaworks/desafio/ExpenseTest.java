package br.com.exactaworks.desafio;

import br.com.exactaworks.desafio.builder.response.ExpenseBuilderResponse;
import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.entity.TagEntity;
import br.com.exactaworks.desafio.mapper.ExpenseMapper;
import br.com.exactaworks.desafio.repository.ExpenseRepository;
import br.com.exactaworks.desafio.service.ExpenseService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ExpenseMapper.class)
public class ExpenseTest {

    @Mock
    private ExpenseRepository expenseRepository;
    @InjectMocks
    private ExpenseService expenseService;
    private ExpenseRequest expenseRequest;
    private ExpenseResponse expenseResponse;

    @BeforeEach
    public void setUp(){
        this.expenseRequest = new ExpenseRequest();

      MockitoAnnotations.openMocks(this);
      mockStatic(ExpenseMapper.class);

        this.expenseResponse = new ExpenseBuilderResponse()
                .withId(1L)
                .withName("Pedro Sampaio")
                .withDescription("Pagamento Nubank")
                .withValue(BigDecimal.valueOf(2500.00))
                .withLocalDateTime(LocalDateTime.now())
                .withTag(TagEntity.NOT_PAYED)
                .build();
    }

    @Test
    public void saveExpenseTestSuccess(){
        expenseRequest.setName("Pedro Sampaio");
        expenseRequest.setDescription("Pagamento NuBank");
        expenseRequest.setValue(BigDecimal.valueOf(2500.00));

        when(expenseService.saveExpense(any())).thenReturn(expenseResponse);

        verify(expenseRepository, times(1)).save(any());

//        when(expenseService.saveExpense(expenseRequest)).thenReturn(expenseResponse);
    }


}
