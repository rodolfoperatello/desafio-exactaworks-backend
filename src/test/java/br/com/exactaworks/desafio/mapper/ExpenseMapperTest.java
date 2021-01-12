package br.com.exactaworks.desafio.mapper;

import br.com.exactaworks.desafio.controller.request.ExpenseRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.entity.ExpenseEntity;
import br.com.exactaworks.desafio.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class ExpenseMapperTest {

    private ExpenseRequest expenseRequest;
    private ExpenseEntity expenseEntity;
    private Page<ExpenseEntity> pageExpenseEntities;
    private final LocalDateTime localdateTime = LocalDateTime.now();

    @BeforeEach
    public void setUp(){
        this.expenseRequest = new ExpenseRequest();
        expenseRequest.setUserId(1L);
        expenseRequest.setDescription("Pagamento do carro");
        expenseRequest.setValue(BigDecimal.valueOf(1000));
        expenseRequest.setDateTime(localdateTime.toString());
        expenseRequest.setTag("Veículo");

        var userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Mario");
        userEntity.setLastName("Silva");
        userEntity.setEmail("silva12@gmail.com");
        userEntity.setPassword("silvamario123");

        this.expenseEntity = new ExpenseEntity();
        expenseEntity.setId(1L);
        expenseEntity.setUserEntity(userEntity);
        expenseEntity.setDescription("Pagamento da fatura Nubank");
        expenseEntity.setValue(BigDecimal.valueOf(2000));
        expenseEntity.setTag("Banco");
        expenseEntity.setDateTime(this.localdateTime);

        var expenseEntity2 = new ExpenseEntity();
        expenseEntity2.setId(2L);
        expenseEntity2.setUserEntity(userEntity);
        expenseEntity2.setDescription("Pagamento bicicleta");
        expenseEntity2.setValue(BigDecimal.valueOf(4000));
        expenseEntity2.setTag("Transporte");
        expenseEntity2.setDateTime(this.localdateTime);

        this.pageExpenseEntities = new PageImpl<>(List.of(expenseEntity, expenseEntity2));
    }

    @Test
    public void convertToEntitySuccessful(){
        var expenseEntity = ExpenseMapper.convertToEntity(this.expenseRequest);

        Assertions.assertNotNull(expenseEntity);
        Assertions.assertEquals(ExpenseEntity.class, expenseEntity.getClass());
        Assertions.assertNull(expenseEntity.getUserEntity());
        assertNull(expenseEntity.getId());
        Assertions.assertEquals("Pagamento do carro", expenseEntity.getDescription());
        Assertions.assertEquals(localdateTime, expenseEntity.getDateTime());
        Assertions.assertEquals(BigDecimal.valueOf(1000), expenseEntity.getValue());
        Assertions.assertEquals("Veículo", expenseEntity.getTag());
    }

    @Test
    public void convertToResponseSuccessful(){
        var expenseResponse = ExpenseMapper.convertToResponse(this.expenseEntity);

        Assertions.assertNotNull(expenseResponse);
        Assertions.assertEquals(ExpenseResponse.class, expenseResponse.getClass());
        Assertions.assertEquals(1L, expenseResponse.getId());
        Assertions.assertEquals("Mario Silva", expenseResponse.getFullName());
        Assertions.assertEquals("Pagamento da fatura Nubank", expenseResponse.getDescription());
        Assertions.assertEquals(BigDecimal.valueOf(2000), expenseResponse.getValue());
        Assertions.assertEquals(this.localdateTime, expenseResponse.getDateTime());
        Assertions.assertEquals("Banco", expenseResponse.getTag());
    }

    @Test
    public void convertToPageResponseSuccessful(){
        var pageExpenseResponses = ExpenseMapper.convertToPageResponse(this.pageExpenseEntities);
        var expenseResponseList = pageExpenseResponses.getContent();

        Assertions.assertNotNull(pageExpenseResponses);
        Assertions.assertNotNull(expenseResponseList);
        Assertions.assertFalse(expenseResponseList.isEmpty());
        Assertions.assertEquals(2, expenseResponseList.size());
        Assertions.assertEquals("Mario Silva", expenseResponseList.get(0).getFullName());
        Assertions.assertEquals("Mario Silva", expenseResponseList.get(1).getFullName());
        Assertions.assertEquals(1, pageExpenseResponses.getTotalPages());
        Assertions.assertEquals(2, pageExpenseResponses.getTotalElements());
    }
}