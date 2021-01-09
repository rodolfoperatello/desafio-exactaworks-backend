package br.com.exactaworks.desafio.repository;

import br.com.exactaworks.desafio.exceptions.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
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

        Assert.assertNotNull(user);
        Assert.assertEquals(email, user.getEmail());
        Assert.assertEquals("Pedro", user.getUsername());
        Assert.assertEquals("Silva", user.getLastName());
    }

    @Test(expected = NotFoundException.class)
    public void findByEmailFail(){
        var user = this.userRepository.findByEmail("emailnotfound@email.com.br")
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Test
    public void findUserByIdSuccessful(){
        Long id = 4L;
        var user = this.userRepository.findUserById(id).get();

        Assert.assertNotNull(user);
        Assert.assertEquals(id, user.getId());
        Assert.assertEquals("fernando_jose@hotmail.com", user.getEmail());
        Assert.assertEquals("Fernando", user.getUsername());
        Assert.assertEquals("José", user.getLastName());
    }

    @Test(expected = NotFoundException.class)
    public void findUserByIdFail(){
        var user = this.userRepository.findUserById(50L)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        Assert.assertNull(user);
    }

    @Test
    public void findAllUsersSuccessful(){
        var users = this.userRepository.findAll();

        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
        Assert.assertEquals(5, users.size());
        Assert.assertEquals("mariana08@hotmail.com", users.get(2).getEmail());
    }

}