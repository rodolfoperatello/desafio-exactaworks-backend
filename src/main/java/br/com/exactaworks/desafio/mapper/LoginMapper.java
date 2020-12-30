package br.com.exactaworks.desafio.mapper;

import br.com.exactaworks.desafio.controller.request.LoginRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public static UsernamePasswordAuthenticationToken toUsernamePasswordAuthenticationToken(LoginRequest loginRequest){
        return new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
