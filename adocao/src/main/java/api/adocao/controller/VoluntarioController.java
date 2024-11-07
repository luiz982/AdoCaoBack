package api.adocao.controller;

import api.adocao.controller.DTO.*;
import api.adocao.entity.*;
import api.adocao.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RequestMapping("/voluntario")
@RestController
public class VoluntarioController {
    private VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @PostMapping
    public ResponseEntity<Voluntario> createVoluntario(@RequestBody CreateVoluntarioDTO voluntarioDTO){
        Voluntario novoVoluntario = voluntarioService.createVoluntario(voluntarioDTO);
        URI location = URI.create("/voluntario/" + novoVoluntario.getId());
        return ResponseEntity.created(location).body(novoVoluntario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> getVoluntarioById(@PathVariable("id") String id){
        var voluntario = voluntarioService.getVoluntarioById(id);
        if(voluntario.isPresent()){
            return ResponseEntity.ok(voluntario.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Voluntario>> getVoluntarios(){
        List voluntarios = voluntarioService.getVoluntarios();
        return ResponseEntity.ok(voluntarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id){
        Integer response = voluntarioService.deleteById(id);
        if(response == 1){
            return ResponseEntity.ok("Deletado com sucesso!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}
