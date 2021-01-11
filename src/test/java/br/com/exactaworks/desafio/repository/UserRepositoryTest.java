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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmailSuccessful(){
        String email = "pedrosilva@hotmail.com";
        var user = this.userRepository.findByEmail(email).get();

        Assertions.assertNotNull(user);
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals("Pedro", user.getUsername());
        Assertions.assertEquals("Silva", user.getLastName());
    }

    @Test
    public void findUserByIdSuccessful(){
        Long id = 4L;
        var user = this.userRepository.findUserById(id).get();

        Assertions.assertNotNull(user);
        Assertions.assertEquals(id, user.getId());
        Assertions.assertEquals("fernando_jose@hotmail.com", user.getEmail());
        Assertions.assertEquals("Fernando", user.getUsername());
        Assertions.assertEquals("José", user.getLastName());
    }

    @Test
    public void findAllUsersSuccessful(){
        var users = this.userRepository.findAll();

        Assertions.assertNotNull(users);
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertEquals(6, users.size());
        Assertions.assertEquals("mariana08@hotmail.com", users.get(2).getEmail());
    }

    //    @Test
//    public void findUserByIdFail(){
//        var exception = Assertions.assertThrows(NotFoundException.class, () -> this.userRepository.findUserById(50L)
//                .orElseThrow(() -> new NotFoundException("Usuário não encontrado")));
//
//        Assertions.assertNotNull(exception);
//        Assertions.assertEquals("Usuário não encontrado", exception.getMessage());
//    }

    //    @Test
//    public void findByEmailFail(){
//        var exception = Assertions.assertThrows(NotFoundException.class,
//                () -> this.userRepository.findByEmail("emailnotfound@email.com.br")
//                        .orElseThrow(() -> new NotFoundException("Usuário não encontrado")));
//
//        Assertions.assertNotNull(exception);
//        Assertions.assertEquals("Usuário não encontrado", exception.getMessage());
//    }


}