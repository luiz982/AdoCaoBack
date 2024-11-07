package api.adocao.controller;

import api.adocao.controller.DTO.CreateAnimalDTO;
import api.adocao.entity.Animal;
import api.adocao.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody CreateAnimalDTO animalDTO){
        Animal novoAnimal = animalService.createAnimal(animalDTO);
        URI location = URI.create("/animais/" + novoAnimal.getId());
        return ResponseEntity.created(location).body(novoAnimal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") String id){
        var animal = animalService.getAnimalById(id);
        if(animal.isPresent()){
            return ResponseEntity.ok(animal.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAnimals(){
        List animais = animalService.getAnimals();
        return ResponseEntity.ok(animais);
    }

    @GetMapping("/adotados")
    public ResponseEntity<List<Animal>> getAnimalsAdotados(){
        List animais = animalService.getAdotados();
        return ResponseEntity.ok(animais);
    }

    @GetMapping("/naoadotados")
    public ResponseEntity<List<Animal>> getAnimalsNaoAdotados(){
        List animais = animalService.getNaoAdotados();
        return ResponseEntity.ok(animais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") String id, @RequestBody CreateAnimalDTO animal){
        try {
            Integer response = animalService.updateById(id, animal);
            if (response == 1) {
                return ResponseEntity.ok("Animal alterado com sucesso!");
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(500)
                    .body("Erro inesperado: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id){
        Integer response = animalService.deleteById(id);
        if(response == 1){
            return ResponseEntity.ok("Deletado com sucesso!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
