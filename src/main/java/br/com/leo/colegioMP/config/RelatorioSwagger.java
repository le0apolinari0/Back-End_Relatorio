package br.com.leo.colegioMP.config;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//url http://localhost:8080/swagger-ui/

public class RelatorioSwagger {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ApiOperation(value = "Listar relatórios", notes = "Lista todos os relatórios")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Relatórios listados com sucesso")
    })
    public @interface ListarRelatorios {}

    public static final String BUSCAR_RELATORIO_POR_ID = "Buscar relatório por ID";
    public static final String RETORNA_RELATORIO_ESPECIFICO = "Retorna um relatório específico";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ApiOperation(value = BUSCAR_RELATORIO_POR_ID, notes = RETORNA_RELATORIO_ESPECIFICO)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Relatório encontrado"),
            @ApiResponse(code = 404, message = "Relatório não encontrado")
    })
    public @interface BuscarRelatorioPorId {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ApiOperation(value = "Cadastrar relatório", notes = "Cadastra um novo relatório")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Relatório cadastrado com sucesso"),
            @ApiResponse(code = 400, message = "Erro ao cadastrar relatório")
    })
    public @interface CadastrarRelatorio {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ApiOperation(value = "Atualizar relatório", notes = "Atualiza um relatório específico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Relatório atualizado com sucesso"),
            @ApiResponse(code = 404, message = "Relatório não encontrado")
    })
    public @interface AtualizarRelatorio {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ApiOperation(value = "Excluir relatório", notes = "Exclui um relatório específico")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Relatório excluído com sucesso"),
            @ApiResponse(code = 404, message = "Relatório não encontrado")
    })
    public @interface ExcluirRelatorio {}

}
