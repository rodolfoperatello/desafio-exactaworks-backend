package br.com.exactaworks.desafio.controller;

import br.com.exactaworks.desafio.controller.request.UserRequest;
import br.com.exactaworks.desafio.controller.response.UserResponse;
import br.com.exactaworks.desafio.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Api(tags = {"User Controller"})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(value = "Find all users in the database",
            notes = "Provide additional information to get the expenses paged",
            response = UserResponse.class)
    public ResponseEntity<Page<UserResponse>> findAllUsers(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findAllUsers(pageable));
    }

    @PostMapping
    @ApiOperation(value = "Create an user",
            notes = "Provide an UserRequest object to create an user",
            response = UserResponse.class)
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(userRequest));
    }


}
