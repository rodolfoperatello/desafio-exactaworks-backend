package br.com.exactaworks.desafio.controller;

import br.com.exactaworks.desafio.controller.request.LoginRequest;
import br.com.exactaworks.desafio.controller.response.ExpenseResponse;
import br.com.exactaworks.desafio.controller.response.TokenResponse;
import br.com.exactaworks.desafio.mapper.LoginMapper;
import br.com.exactaworks.desafio.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/auth")
@Api(tags = {"Authentication Controller"})
@Profile("production")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final Logger log = Logger.getLogger("br.com.exactaworks.desafio.AuthenticationController");

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    @ApiOperation(value = "Authenticate an user",
            notes = "Provide a user's email and password to authenticate",
            response = ExpenseResponse.class)
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginRequest loginRequest){

        try {
            var authentication = authenticationManager.authenticate(
                    LoginMapper.toUsernamePasswordAuthenticationToken(loginRequest));
            var token = tokenService.createToken(authentication);
            log.info("Token: " +token);

            return ResponseEntity.status(HttpStatus.OK).body(new TokenResponse(token, "Bearer"));
        } catch (AuthenticationException authenticationException) {

            log.info("BAD REQUEST");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
