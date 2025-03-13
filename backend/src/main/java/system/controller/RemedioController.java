package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import system.domain.Remedio;
import system.dto.AtualizarRemedioDTO;
import system.dto.DetalharRemedioDTO;
import system.dto.ListarRemediosDTO;
import system.dto.cadastrarRemedioDTO;
import system.service.RemedioService;

import java.util.List;

@RestController
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioService remedioService;

    @PostMapping
    @Transactional
    public DetalharRemedioDTO cadastrarRemedio(@RequestBody cadastrarRemedioDTO remedioDTO) {
        Remedio remedio = remedioService.cadastrar(remedioDTO);

        return new DetalharRemedioDTO(remedio);
    }

    @GetMapping("/ativos")
    public List<ListarRemediosDTO> listarTodosRemediosAtivos() {
        return remedioService.listarTodosRemediosAtivos();
    }

    @GetMapping
    public List<ListarRemediosDTO> listarTodosRemedios() {
        return remedioService.listarTodosRemedios();
    }

    @GetMapping("/{id}")
    public DetalharRemedioDTO detalharRemedio(@PathVariable Long id) {
        return remedioService.detalhar(id);
    }

    @PutMapping
    @Transactional
    public DetalharRemedioDTO atualizarRemedio(@RequestBody AtualizarRemedioDTO remedioDTO) {
        var remedio = remedioService.atualizar(remedioDTO);
        return new DetalharRemedioDTO(remedio);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarRemedio(@PathVariable Long id) {
        remedioService.excluir(id);
        return;
    }


}




























