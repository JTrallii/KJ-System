package system.dto;

import jakarta.persistence.*;
import system.domain.Laboratorio;
import system.domain.Remedio;

public record ListarRemediosDTO(
    String nome,
    String laboratorio,
    String principioAtivo,
    String posologia,
    String indicacoes,
    String contraIndicacoes,
    String categoria
) {
    public ListarRemediosDTO(Remedio remedio) {
        this(remedio.getNome(), String.valueOf(remedio.getLaboratorio()), remedio.getPrincipioAtivo(), remedio.getPosologia(), remedio.getIndicacoes(),
            remedio.getContraIndicacoes(), remedio.getCategoria());
    }
}