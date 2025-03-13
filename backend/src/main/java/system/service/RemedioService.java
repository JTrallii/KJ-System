package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.domain.Laboratorio;
import system.domain.Remedio;
import system.dto.*;
import system.repository.LaboratorioRepository;
import system.repository.RemedioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RemedioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Autowired
    private RemedioRepository remedioRepository;

    public Remedio cadastrar(cadastrarRemedioDTO remedioDTO) {
        Laboratorio laboratorio = laboratorioRepository.findByNome(remedioDTO.laboratorio())
            .orElseThrow(() -> new RuntimeException("Laboratório não encontrado !"));

        Remedio remedio = new Remedio(remedioDTO);
        remedio.setAtivo(true);
        remedio.setLaboratorio(laboratorio);

        return remedioRepository.save(remedio);
    }

    public List<ListarRemediosDTO> listarTodosRemediosAtivos() {
        return remedioRepository.findAllByAtivoTrue() // Retorna Optional<List<Produto>>
            .orElse(List.of()) // Substitui por uma lista vazia caso esteja vazio
            .stream() // Converte a lista em um stream
            .map(ListarRemediosDTO::new) // Mapeia Produto para DadosListagemProdutos
            .toList(); // Converte de volta para lista
    }

    public List<ListarRemediosDTO> listarTodosRemedios() {
        return remedioRepository.findAll()
            .stream()
            .map(ListarRemediosDTO::new)
            .toList();
    }

    public DetalharRemedioDTO detalhar(Long id) {
        var remedio = remedioRepository.getReferenceById(id);
        return new DetalharRemedioDTO(remedio);
    }

    public Remedio atualizar(AtualizarRemedioDTO remedioDTO) {
        var remedio = remedioRepository.getReferenceById(remedioDTO.id());

        Laboratorio laboratorio = laboratorioRepository.findByNome(remedioDTO.laboratorio())
            .orElseThrow(() -> new RuntimeException("Laboratório não encontrado !"));

        remedio.atualizarInformacoes(remedioDTO);
        remedio.setLaboratorio(laboratorio);

        return remedio;
    }

    public void excluir(Long id) {
        Optional<Remedio> remedio = remedioRepository.findById(id);
        if (remedio.isPresent()) {
            Remedio remedioExcluido = remedio.get();
            remedioExcluido.setAtivo(false);
            remedioRepository.save(remedioExcluido);
        }
    }
}




























