package br.com.exactaworks.desafio.repository;

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

    @Test
    public void findAllPerfilSuccessful(){
        var perfilList = this.perfilRepository.findAll();

        Assertions.assertNotNull(perfilList);
        Assertions.assertFalse(perfilList.isEmpty());
        Assertions.assertEquals(2, perfilList.size());
        Assertions.assertEquals("ADMIN", perfilList.get(0).getName());
    }

//    @Test
//    public void findByNameFail(){
//        var exception = Assertions.assertThrows(NotFoundException.class,
//                () -> this.perfilRepository.findByName("userNotFound")
//                .orElseThrow(() -> new NotFoundException("User not found")));
//
//        Assertions.assertNotNull(exception);
//        Assertions.assertEquals("User not found", exception.getMessage());
//    }
}
