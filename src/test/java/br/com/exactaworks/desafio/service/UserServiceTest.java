package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.controller.request.UserRequest;
import br.com.exactaworks.desafio.controller.response.UserResponse;
import br.com.exactaworks.desafio.entity.UserEntity;
import br.com.exactaworks.desafio.exceptions.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class UserServiceTest {

    @Autowired
    private UserService userService;
    private UserRequest userRequest;
    private Pageable pageable;

    @BeforeEach
    public void setUp(){
        this.userRequest = new UserRequest();
        userRequest.setFisrtName("Antonio");
        userRequest.setLastName("Silva");
        userRequest.setEmail("antonio19@gmail.com");
        userRequest.setPassword("antoniopw");

        this.pageable = PageRequest.of(0, 50);
    }

    @Test
    public void createUserSuccessful(){
        var userResponse = this.userService.createUser(this.userRequest);

        Assertions.assertNotNull(userResponse);
        Assertions.assertEquals(6L, userResponse.getId());
        Assertions.assertEquals("Antonio Silva", userResponse.getFullName());
        Assertions.assertEquals("antonio19@gmail.com", userResponse.getEmail());
        Assertions.assertEquals(UserResponse.class, userResponse.getClass());
    }

    @Test
    public void findAllUsersSuccessful(){
        var users = this.userService.findAllUsers(this.pageable);
        var usersList = users.getContent();

        Assertions.assertNotNull(users);
        Assertions.assertEquals(6, usersList.size());
        Assertions.assertEquals("Pedro Silva", usersList.get(0).getFullName());
        Assertions.assertEquals("Carlos Roberto", usersList.get(1).getFullName());
        Assertions.assertEquals(UserResponse.class, usersList.get(0).getClass());
        Assertions.assertEquals(0, users.getNumber());
        Assertions.assertEquals(1, users.getTotalPages());
        Assertions.assertEquals(6, users.getTotalElements());
    }

    @Test
    public void findUserEntityByIdSuccessful(){
        var userEntity = this.userService.findUserEntityById(3L);

        Assertions.assertNotNull(userEntity);
        Assertions.assertEquals(3L, userEntity.getId());
        Assertions.assertEquals("Mariana", userEntity.getName());
        Assertions.assertEquals("B. Ferreira", userEntity.getLastName());
        Assertions.assertEquals("$2y$12$dag5AxvurR70mSU0C.YhUOT306l2BWjCiL084YoNx2GONlBIQ7BxK", userEntity.getPassword());
        Assertions.assertEquals(UserEntity.class, userEntity.getClass());
    }

    @Test
    public void findUserEntityByIdFailAndThrowsNotFoundException(){
        var exception = Assertions.assertThrows(
                NotFoundException.class, () -> this.userService.findUserEntityById(900L));

        Assertions.assertEquals(NotFoundException.class, exception.getClass());
        Assertions.assertEquals("Usuário não encontrado", exception.getMessage());
    }

}