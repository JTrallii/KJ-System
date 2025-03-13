package system.dto;

import system.domain.Laboratorio;

public record ListarLaboratoriosDTO(
    String nome
) {
    public ListarLaboratoriosDTO(Laboratorio laboratorio) {
        this(laboratorio.getNome());
    }
}
