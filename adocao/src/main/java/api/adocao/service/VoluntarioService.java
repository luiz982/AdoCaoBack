package api.adocao.service;

import api.adocao.controller.DTO.*;
import api.adocao.entity.*;
import api.adocao.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class VoluntarioService {

    private VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public Voluntario createVoluntario(CreateVoluntarioDTO createVoluntarioDTO){

        var entity = new Voluntario(
                createVoluntarioDTO.nome(),
                createVoluntarioDTO.dataNascimento(),
                createVoluntarioDTO.tel(),
                createVoluntarioDTO.email()
                );

        return voluntarioRepository.save(entity);
    }

    public Optional<Voluntario> getVoluntarioById(String id){
        Integer voluntarioId = Integer.parseInt(id);
        return voluntarioRepository.findById(voluntarioId);
    }

    public List<Voluntario> getVoluntarios(){
        return voluntarioRepository.findAll();
    }

    public Integer deleteById(String id){
        Integer voluntarioId = Integer.parseInt(id);
        var existeVoluntario = voluntarioRepository.existsById(voluntarioId);
        if(existeVoluntario){
            voluntarioRepository.deleteById(voluntarioId);
            return 1;
        }
        return 0;
    }
}
