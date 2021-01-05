package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.entity.PerfilEntity;
import br.com.exactaworks.desafio.exception.GenericException;
import br.com.exactaworks.desafio.repository.PerfilRepository;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public PerfilEntity findPerfilByName(String perfilName){
        return this.perfilRepository.findByName(perfilName).orElseThrow(() -> new GenericException("Perfil não encontrado"));
    }
}
