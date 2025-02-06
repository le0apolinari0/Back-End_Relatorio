package br.com.leo.colegioMP.Controller;

import br.com.leo.colegioMP.config.RelatorioSwagger;
import br.com.leo.colegioMP.model.report.Relatorio;
import br.com.leo.colegioMP.relatorioDto.*;
import br.com.leo.colegioMP.repository.RelatorioRepository;
import br.com.leo.colegioMP.service.RelatorioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioRepository repository;
    @Autowired
    private RelatorioService service;


    @GetMapping("/{id}")
    @RelatorioSwagger.BUSCAR_RELATORIO_POR_ID
    public ResponseEntity<Relatorio> buscarRelatorioPorId(@PathVariable @ApiParam(value = "ID do relatório") Long id) {
        Relatorio relatorio = service.buscarRelatorioPorId(id);
        return ResponseEntity.ok(relatorio);
    }

    @PostMapping
    @RelatorioSwagger.CadastrarRelatorio
    public ResponseEntity<Relatorio> cadastrar(@RequestBody @Valid @ApiParam(value = "Dados do relatório") CadastroRelatorio dados) {
        Relatorio salvo = service.cadastrarRelatorio(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }


    @PutMapping("/{id}")
    @RelatorioSwagger.AtualizarRelatorio
    public ResponseEntity<Relatorio> atualizarRelatorio(@PathVariable @ApiParam(value = "ID do relatório")
            Long id, @RequestBody @ApiParam(value = "Dados do relatório") AtualizarRelatorio dados) {
        Relatorio relatorioAtualizado = service.atualizarRelatorio(id, dados);
        return ResponseEntity.ok(relatorioAtualizado);
    }

    @DeleteMapping("/{id}")
    @RelatorioSwagger.ExcluirRelatorio
    public ResponseEntity excluir(@PathVariable @ApiParam(value = "ID do relatório") Long id) {
        service.excluirRelatorio(id);
        return ResponseEntity.noContent().build();
    }

}



