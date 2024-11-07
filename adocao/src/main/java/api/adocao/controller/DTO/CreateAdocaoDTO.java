package api.adocao.controller.DTO;

import api.adocao.entity.*;

import java.util.Date;

public record CreateAdocaoDTO(Integer voluntarioId, Integer animalId, String descricao, Date dataAdocao, String nomeAdotante, String cpfAdotante, String telAdotante) {

}