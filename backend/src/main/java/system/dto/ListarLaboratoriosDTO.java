package system.dto;

import system.domain.Laboratorio;

public record ListarLaboratoriosDTO(
    Long id,
    String nome
) {
    public ListarLaboratoriosDTO(Laboratorio laboratorio) {
        this(laboratorio.getId(), laboratorio.getNome());
    }
}
