package br.com.exactaworks.desafio.builder.response;

import br.com.exactaworks.desafio.controller.response.UserResponse;

public class UserBuilderResponse {

    private final UserResponse userResponse;

    public UserBuilderResponse() {
        this.userResponse = new UserResponse();
    }

    public UserBuilderResponse withId(Long id){
        this.userResponse.setId(id);
        return this;
    }

    public UserBuilderResponse withFullName(String fullName){
        this.userResponse.setFullName(fullName);
        return this;
    }

    public UserBuilderResponse withEmail(String email){
        this.userResponse.setEmail(email);
        return this;
    }

    public UserResponse build(){
        return this.userResponse;
    }

}
