package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.entity.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class AuthenticationServiceTest {

    @Autowired
    private AuthenticationService authenticationService;

    @Test
    public void loadUserByUsernameSuccessful(){
        var user = this.authenticationService.loadUserByUsername("mariana08@hotmail.com");
        var userFirstAuthority = user.getAuthorities().stream().findFirst().get().getAuthority();

        Assertions.assertNotNull(user);
        Assertions.assertEquals(UserEntity.class, user.getClass());
        Assertions.assertEquals("Mariana", user.getUsername());
        Assertions.assertEquals("$2y$12$dag5AxvurR70mSU0C.YhUOT306l2BWjCiL084YoNx2GONlBIQ7BxK", user.getPassword());
        Assertions.assertEquals("USER", userFirstAuthority);
    }

    @Test
    public void loadUserByUsernameFailAndThrowsUsernameNotFoundException(){
        var exception = Assertions.assertThrows(UsernameNotFoundException.class,
                () -> this.authenticationService.loadUserByUsername("usernamenotfound@gmail.com"));

        Assertions.assertNotNull(exception);
        Assertions.assertEquals(UsernameNotFoundException.class, exception.getClass());
        Assertions.assertEquals("Dados inválidos", exception.getMessage());
    }
}