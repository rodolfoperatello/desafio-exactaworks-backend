package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.controller.request.UserRequest;
import br.com.exactaworks.desafio.controller.response.UserResponse;
import br.com.exactaworks.desafio.entity.UserEntity;
import br.com.exactaworks.desafio.mapper.UserMapper;
import br.com.exactaworks.desafio.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PerfilService perfilService;

    public UserService(UserRepository userRepository, PerfilService perfilService) {
        this.userRepository = userRepository;
        this.perfilService = perfilService;
    }

    @Transactional
    public UserResponse createUser(UserRequest userRequest){
        return UserMapper.convertToResponse(this.userRepository.save(createUserEntity(userRequest)));
    }

    private UserEntity createUserEntity(UserRequest userRequest) {
        var perfil = perfilService.findPerfilByName("user");
        var userEntity = UserMapper.convertToEntity(userRequest);
        userEntity.addPerfil(perfil);

        return userEntity;
    }

    public Page<UserResponse> findAllUsers(Pageable pageable) {
        return UserMapper.convertToPageUserResponse(this.userRepository.findAll(pageable));
    }
}
