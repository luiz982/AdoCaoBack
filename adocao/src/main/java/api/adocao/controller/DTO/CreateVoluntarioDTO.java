package api.adocao.controller.DTO;

import java.util.Date;

public record CreateVoluntarioDTO(String nome,  Date dataNascimento, String tel, String email) {

}