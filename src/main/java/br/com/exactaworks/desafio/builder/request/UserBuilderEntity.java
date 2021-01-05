package br.com.exactaworks.desafio.builder.request;

import br.com.exactaworks.desafio.entity.UserEntity;

public class UserBuilderEntity {

    private UserEntity userEntity;

    public UserBuilderEntity(){
        this.userEntity = new UserEntity();
    }

    public UserBuilderEntity withName(String name){
        this.userEntity.setName(name);
        return this;
    }

    public UserBuilderEntity withLastName(String lastName){
        this.userEntity.setLastName(lastName);
        return this;
    }

    public UserBuilderEntity withEmail(String email){
        this.userEntity.setEmail(email);
        return this;
    }

    public UserBuilderEntity withPassword(String password){
        this.userEntity.setPassword(password);
        return this;
    }

    public UserEntity build(){
        return this.userEntity;
    }
}

