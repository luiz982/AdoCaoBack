package api.adocao.service;

import api.adocao.controller.DTO.*;
import api.adocao.entity.*;
import api.adocao.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class AdocaoService {
    private AdocaoRepository adocaoRepository;
    private VoluntarioRepository voluntarioRepository;
    private AnimalRepository animalRepository;

    public AdocaoService(AdocaoRepository adocaoRepository, VoluntarioRepository voluntarioRepository, AnimalRepository animalRepository) {
        this.adocaoRepository = adocaoRepository;
        this.voluntarioRepository = voluntarioRepository;
        this.animalRepository = animalRepository;
    }

    public Adocao createAdocao(CreateAdocaoDTO createAdocaoDTO) {
        Integer voluntarioId = createAdocaoDTO.voluntarioId();
        Integer animalId = createAdocaoDTO.animalId();

        var voluntario = voluntarioRepository.findById(voluntarioId);
        var animal = animalRepository.findById(animalId);

        if (voluntario.isEmpty()) {
            throw new IllegalArgumentException("Voluntário com ID " + voluntarioId + " não encontrado.");
        }
        if (animal.isEmpty()) {
            throw new IllegalArgumentException("Animal com ID " + animalId + " não encontrado.");
        }

        Animal animalEntity = animal.get();
        if (animalEntity.getStatus() == false) {
            animalEntity.setStatus(true);
            animalRepository.save(animalEntity);
        } else {
            throw new IllegalArgumentException("Este animal já está adotado.");
        }

        var entity = new Adocao(
                voluntario.get(),
                animal.get(),
                createAdocaoDTO.descricao(),
                createAdocaoDTO.dataAdocao(),
                createAdocaoDTO.nomeAdotante(),
                createAdocaoDTO.cpfAdotante(),
                createAdocaoDTO.telAdotante()
        );

        return adocaoRepository.save(entity);
    }
    public List<Adocao> getAdocoes(){
        return adocaoRepository.findAll();
    }

    public Integer deleteById(String id){
        Integer adocaoId = Integer.parseInt(id);
        var existeAdocao = adocaoRepository.existsById(adocaoId);
        if(existeAdocao){
            var adocao = adocaoRepository.findById(adocaoId);
            Animal animal = adocao.get().getAnimal();
            if (animal.getStatus() == true) {
                animal.setStatus(false);
                animalRepository.save(animal);
            }
            adocaoRepository.deleteById(adocaoId);
            return 1;
        }
        return 0;
    }




}
