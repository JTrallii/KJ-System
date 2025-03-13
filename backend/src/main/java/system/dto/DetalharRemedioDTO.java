package system.dto;

import system.domain.Remedio;

public record DetalharRemedioDTO(
    Long id,
    String nome,
    String laboratorio,
    String principioAtivo,
    String posologia,
    String indicacoes,
    String contraIndicacoes,
    String categoria
) {
    public DetalharRemedioDTO(Remedio remedio) {
        this(remedio.getId(), remedio.getNome(), String.valueOf(remedio.getLaboratorio()), remedio.getPrincipioAtivo(),
            remedio.getPosologia(), remedio.getIndicacoes(), remedio.getContraIndicacoes(), remedio.getCategoria());
    }
}
