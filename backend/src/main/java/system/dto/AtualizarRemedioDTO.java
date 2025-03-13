package system.dto;

public record AtualizarRemedioDTO(
    Long id,
    String nome,
    String laboratorio,
    String principioAtivo,
    String posologia,
    String indicacoes,
    String contraIndicacoes,
    String categoria
) {
}
