package api.adocao.controller;


import api.adocao.controller.DTO.CreateAdocaoDTO;
import api.adocao.entity.Adocao;
import api.adocao.entity.Animal;
import api.adocao.service.AdocaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {
    private final AdocaoService adocaoService;

    public AdocaoController(AdocaoService adocaoService) {
        this.adocaoService = adocaoService;
    }

    @PostMapping
    public ResponseEntity createAdocao(@RequestBody CreateAdocaoDTO createAdocaoDTO) {
        try {
            Adocao adocao = adocaoService.createAdocao(createAdocaoDTO);
            return ResponseEntity.ok(adocao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Adocao>> getAdocoes(){
        List adocoes = adocaoService.getAdocoes();
        return ResponseEntity.ok(adocoes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id){
        Integer response = adocaoService.deleteById(id);
        if(response == 1){
            return ResponseEntity.ok("Deletado com sucesso!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
