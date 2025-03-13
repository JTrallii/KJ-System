package system.dto;

public record cadastrarRemedioDTO(
    String nome,
    String laboratorio,
    String principioAtivo,
    String posologia,
    String indicacoes,
    String contraIndicacoes,
    String categoria

) {
}
