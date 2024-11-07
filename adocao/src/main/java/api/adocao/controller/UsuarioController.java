package api.adocao.controller;

import api.adocao.controller.DTO.*;
import api.adocao.entity.*;
import api.adocao.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody CreateUsuarioDTO usuarioDTO){
        Usuario novoUsuario = usuarioService.createUsuario(usuarioDTO);
        URI location = URI.create("/usuario/" + novoUsuario.getId());
        return ResponseEntity.created(location).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestParam String usuario, @RequestParam String senha) {
        boolean response = usuarioService.login(usuario, senha);
        if (response) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(403).body("Usuário ou senha inválidos.");
        }
    }




}
