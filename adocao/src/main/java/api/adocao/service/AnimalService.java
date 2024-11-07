package api.adocao.service;

import api.adocao.controller.DTO.CreateAnimalDTO;
import api.adocao.entity.Animal;
import api.adocao.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;
import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal createAnimal(CreateAnimalDTO createAnimalDTO){
        byte[] foto = null;
        if (createAnimalDTO.foto() != null && createAnimalDTO.foto() != "" && !createAnimalDTO.foto().isEmpty() && !createAnimalDTO.foto().isBlank()) {
            foto = Base64.getDecoder().decode(createAnimalDTO.foto());
        }
        var entity = new Animal(
                createAnimalDTO.nome(),
                createAnimalDTO.raca(),
                createAnimalDTO.dataNascimento(),
                createAnimalDTO.Informacoes(),
                createAnimalDTO.Status(),
                foto,
                createAnimalDTO.tipo(),
                createAnimalDTO.Sexo());

        return animalRepository.save(entity);
    }

    public Optional<Animal> getAnimalById(String id){
        Integer animalId = Integer.parseInt(id);
        return animalRepository.findById(animalId);
    }

    public List<Animal> getAnimals(){
        return animalRepository.findAll();
    }

    public List<Animal> getAdotados(){
        return animalRepository.findByStatus(true);
    }

    public List<Animal> getNaoAdotados(){
        return animalRepository.findByStatus(false);
    }

    public Integer deleteById(String id){
        Integer animalId = Integer.parseInt(id);
        var existeAnimal = animalRepository.existsById(animalId);
        if(existeAnimal){
            animalRepository.deleteById(animalId);
            return 1;
        }
        return 0;
    }

    public Integer updateById(String id, CreateAnimalDTO animal){
        try {
            Integer animalId = Integer.parseInt(id);
            var existeAnimal = animalRepository.findById(animalId);
            if (existeAnimal.isPresent()) {
                var animalBanco = existeAnimal.get();
                if (animal.tipo() != null) {
                    animalBanco.setTipo(animal.tipo());
                }
                if (animal.Status() != null) {
                    animalBanco.setStatus(animal.Status());
                }
                if (animal.foto() != null && animal.foto() != "" && !animal.foto().isEmpty() && !animal.foto().isBlank()) {
                    var foto = Base64.getDecoder().decode(animal.foto());
                    animalBanco.setFoto(foto);
                }
                if (animal.dataNascimento() != null) {
                    animalBanco.setDataNascimento(animal.dataNascimento());
                }
                if (animal.Sexo() == 'M' || animal.Sexo() == 'F') {
                    animalBanco.setSexo(animal.Sexo());
                }
                if (animal.nome() != null) {
                    animalBanco.setNome(animal.nome());
                }
                if (animal.raca() != null) {
                    animalBanco.setRaca(animal.raca());
                }
                if (animal.Informacoes() != null) {
                    animalBanco.setInformacoes(animal.Informacoes());
                }
                animalRepository.save(animalBanco);
                return 1;
            }
            return 0;
        }catch (Exception e){
            throw e;
        }
    }

}
