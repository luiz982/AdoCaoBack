package api.adocao.service;

import api.adocao.controller.DTO.*;
import api.adocao.entity.*;
import api.adocao.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private VoluntarioRepository voluntarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, VoluntarioRepository voluntarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.voluntarioRepository = voluntarioRepository;
    }

    public Usuario createUsuario(CreateUsuarioDTO createUsuarioDTO){
        Integer voluntarioId = createUsuarioDTO.VoluntarioId();
        var voluntario = voluntarioRepository.findById(voluntarioId);

        if (voluntario.isEmpty()) {
            throw new IllegalArgumentException("Voluntário com ID " + voluntarioId + " não encontrado.");
        }

        var entity = new Usuario(
                createUsuarioDTO.usuario(),
                createUsuarioDTO.senha(),
                voluntario.get()
        );

        return usuarioRepository.save(entity);
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public boolean login(String usuario, String senha) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByUsuario(usuario);

        if (usuarioEncontrado.isPresent()) {
            Usuario user = usuarioEncontrado.get();
            return user.getSenha().equals(senha);
        }

        return false;
    }

}
