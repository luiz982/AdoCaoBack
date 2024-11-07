package api.adocao.controller.DTO;

import java.util.Date;

public record CreateAnimalDTO(String nome, String raca, Date dataNascimento, String Informacoes, Boolean Status, String foto, String tipo, char Sexo) {

}
