package system.dto;

import system.domain.Laboratorio;

import java.util.Optional;

public record DetalharLaboratorioDTO(
    Long id,
    String nome
) {
    public DetalharLaboratorioDTO(Laboratorio laboratorio) {
        this(laboratorio.getId(), laboratorio.getNome());
    }
}
