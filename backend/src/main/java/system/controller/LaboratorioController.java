package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import system.domain.Laboratorio;
import system.dto.*;
import system.service.LaboratorioService;

import java.util.List;

@RestController
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @PostMapping
    @Transactional
    public DetalharLaboratorioDTO cadastrarLaboratorio(@RequestBody CadastrarLaboratorioDTO laboratorioDTO) {
        Laboratorio laboratorio = laboratorioService.cadastrar(laboratorioDTO);

        return new DetalharLaboratorioDTO(laboratorio);
    }

    @GetMapping("/ativos")
    public List<ListarLaboratoriosDTO> listarTodosLaboratoriosAtivos() {
        return laboratorioService.listarTodosLaboratoriosAtivos();
    }

    @GetMapping
    public List<ListarLaboratoriosDTO> listarTodosLaboratorios() {
        return laboratorioService.listarLabaratorios();
    }

    @GetMapping("/{id}")
    public DetalharLaboratorioDTO detalharLaboratorio(@PathVariable Long id) {
        return laboratorioService.detalhar(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public DetalharLaboratorioDTO atualizarLaboratorio(@RequestBody AtualizarLaboratorioDTO laboratorioDTO) {
        var laboratorio = laboratorioService.atualizar(laboratorioDTO);
        return new DetalharLaboratorioDTO(laboratorio);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarLaboratorio(@PathVariable Long id) {
        laboratorioService.excluir(id);
    }
}
