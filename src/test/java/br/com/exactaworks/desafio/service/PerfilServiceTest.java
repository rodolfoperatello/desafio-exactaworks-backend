package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.entity.PerfilEntity;
import br.com.exactaworks.desafio.exceptions.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class PerfilServiceTest {

    @Autowired
    private PerfilService perfilService;

    @Test
    public void findPerfilByNameSuccessful(){
        var perfilEntity = this.perfilService.findPerfilByName("USER");

        Assertions.assertNotNull(perfilEntity);
        Assertions.assertEquals(2L, perfilEntity.getId());
        Assertions.assertEquals("USER", perfilEntity.getName());
        Assertions.assertEquals(PerfilEntity.class, perfilEntity.getClass());
    }

    @Test
    public void findPerfilByNameFailAndThrowsNotFoundException(){
        var exception = Assertions.assertThrows(NotFoundException.class,
                () -> this.perfilService.findPerfilByName("perfilNotFound"));

        Assertions.assertNotNull(exception);
        Assertions.assertEquals(NotFoundException.class, exception.getClass());
        Assertions.assertEquals("Perfil não encontrado", exception.getMessage());
    }

}