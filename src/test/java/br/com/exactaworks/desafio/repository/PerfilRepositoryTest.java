package br.com.exactaworks.desafio.repository;

import br.com.exactaworks.desafio.exceptions.exception.NotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PerfilRepositoryTest {

    @Autowired
    private PerfilRepository perfilRepository;

    @Test
    public void findByNameSuccessful() {
        var perfilName = "USER";
        var perfil = this.perfilRepository.findByName(perfilName);

        Assertions.assertNotNull(perfil);
        Assertions.assertEquals(perfilName, perfil.get().getName());
    }

    @Test(expected = NotFoundException.class)
    public void findByNameFail(){
        var perfilName = "userNotFound";
        var perfil = this.perfilRepository.findByName(perfilName)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Assertions.assertNull(perfil);
    }

    @Test
    public void findAllPerfilSuccessful(){
        var perfilList = this.perfilRepository.findAll();

        Assertions.assertNotNull(perfilList);
        Assertions.assertFalse(perfilList.isEmpty());
        Assertions.assertEquals(2, perfilList.size());
        Assertions.assertEquals("ADMIN", perfilList.get(0).getName());
    }
}