package br.com.exactaworks.desafio.mapper;

import br.com.exactaworks.desafio.builder.request.UserBuilderEntity;
import br.com.exactaworks.desafio.builder.response.UserBuilderResponse;
import br.com.exactaworks.desafio.controller.request.UserRequest;
import br.com.exactaworks.desafio.controller.response.UserResponse;
import br.com.exactaworks.desafio.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    public static UserEntity convertToEntity (UserRequest userRequest){
        return new UserBuilderEntity()
                .withName(userRequest.getName())
                .withLastName(userRequest.getLastName())
                .withEmail(userRequest.getEmail())
                .withPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
                .build();
    }

    public static UserResponse convertToResponse(UserEntity userEntity){
        return new UserBuilderResponse()
                .withId(userEntity.getId())
                .withFullName(userEntity.getName().concat(" ").concat(userEntity.getLastName()))
                .withEmail(userEntity.getEmail())
                .build();
    }

    public static Page<UserResponse> convertToPageUserResponse(Page<UserEntity> pageUserEntity) {
        return pageUserEntity.map(UserMapper::convertToResponse);
    }
}
