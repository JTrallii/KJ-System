package system.domain;

import jakarta.persistence.*;
import lombok.*;
import system.dto.AtualizarLaboratorioDTO;

import java.util.List;
import java.util.Optional;

@Getter
@Table(name = "laboratorios")
@Entity(name = "Laboratorio")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Nome do laboratório (ex: Medley, Neo Química)

    @OneToMany(mappedBy = "laboratorio")
    private List<Remedio> remedios; // Lista de remédios fabricados por este laboratório

    private boolean ativo;

    public void atualizarInformacoes(AtualizarLaboratorioDTO laboratorioDTO) {
        if (laboratorioDTO != null) {
            this.nome = Optional.ofNullable(laboratorioDTO.nome()).orElse(this.nome);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
