package system.domain;

import jakarta.persistence.*;
import lombok.*;
import system.dto.AtualizarLaboratorioDTO;
import system.dto.AtualizarRemedioDTO;
import system.dto.cadastrarRemedioDTO;

import java.util.Optional;

@Table(name = "remedios")
@Entity(name = "Remedio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;  // Nome do medicamento

    @ManyToOne
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;

    private String principioAtivo; // Substância principal (ex: Paracetamol)
    private String posologia;  // Instruções de uso (ex: "1 comprimido a cada 8 horas")
    private String indicacoes;  // Para que serve (ex: "Dor, febre")
    private String contraIndicacoes; // Quem não deve tomar (ex: "Gestantes, alérgicos a dipirona")
    private String categoria;  // Tipo do medicamento (ex: "Analgesico, Antitérmico")
    private boolean ativo;

    public Remedio(cadastrarRemedioDTO remedioDTO) {
        this.nome = remedioDTO.nome();
        this.principioAtivo = remedioDTO.principioAtivo();
        this.posologia = remedioDTO.posologia();
        this.indicacoes = remedioDTO.indicacoes();
        this.contraIndicacoes = remedioDTO.contraIndicacoes();
        this.categoria = remedioDTO.categoria();
        this.ativo = true;
    }

    public void atualizarInformacoes(AtualizarRemedioDTO remedioDTO) {
        if (remedioDTO != null) {
            this.nome = Optional.ofNullable(remedioDTO.nome()).orElse(this.nome);
            this.principioAtivo = Optional.ofNullable(remedioDTO.principioAtivo()).orElse(this.principioAtivo);
            this.posologia = Optional.ofNullable(remedioDTO.posologia()).orElse(this.posologia);
            this.indicacoes = Optional.ofNullable(remedioDTO.indicacoes()).orElse(this.indicacoes);
            this.contraIndicacoes = Optional.ofNullable(remedioDTO.contraIndicacoes()).orElse(this.contraIndicacoes);
            this.categoria = Optional.ofNullable(remedioDTO.categoria()).orElse(this.categoria);
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}





















