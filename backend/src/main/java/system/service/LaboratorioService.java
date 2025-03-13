package system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.domain.Laboratorio;
import system.dto.AtualizarLaboratorioDTO;
import system.dto.CadastrarLaboratorioDTO;
import system.dto.DetalharLaboratorioDTO;
import system.dto.ListarLaboratoriosDTO;
import system.repository.LaboratorioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    public Laboratorio cadastrar(CadastrarLaboratorioDTO laboratorioDTO) {
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setNome(laboratorioDTO.nome());
        laboratorio.setAtivo(true);

        return laboratorioRepository.save(laboratorio);
    }

    public List<ListarLaboratoriosDTO> listarTodosLaboratoriosAtivos() {
        return laboratorioRepository.findAllByAtivoTrue() // Retorna Optional<List<Produto>>
            .orElse(List.of()) // Substitui por uma lista vazia caso esteja vazio
            .stream() // Converte a lista em um stream
            .map(ListarLaboratoriosDTO::new) // Mapeia Produto para DadosListagemProdutos
            .toList(); // Converte de volta para lista
    }

    public List<ListarLaboratoriosDTO> listarLabaratorios() {
        return laboratorioRepository.findAll()
            .stream()
            .map(ListarLaboratoriosDTO::new)
            .toList();
    }

    public DetalharLaboratorioDTO detalhar(Long id) {
        var laboratorio = laboratorioRepository.getReferenceById(id);
        return new DetalharLaboratorioDTO(laboratorio);
    }

    public Laboratorio atualizar(AtualizarLaboratorioDTO laboratorioDTO) {
        var laboratorio = laboratorioRepository.getReferenceById(laboratorioDTO.id());
        laboratorio.atualizarInformacoes(laboratorioDTO);
        return laboratorio;
    }

    public void excluir(Long id) {
        Optional<Laboratorio> laboratorio = laboratorioRepository.findById(id);
        if (laboratorio.isPresent()) {
            Laboratorio laboratorioExcluido = laboratorio.get();
            laboratorioExcluido.setAtivo(false);
            laboratorioRepository.save(laboratorioExcluido);
        }
    }

}



























