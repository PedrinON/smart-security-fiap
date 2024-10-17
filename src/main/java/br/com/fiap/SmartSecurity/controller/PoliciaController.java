package br.com.fiap.SmartSecurity.controller;

import br.com.fiap.SmartSecurity.dto.PoliciaCadastroDto;
import br.com.fiap.SmartSecurity.dto.PoliciaExibirDto;
import br.com.fiap.SmartSecurity.model.Policia;
import br.com.fiap.SmartSecurity.service.PoliciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PoliciaController {

    @Autowired
    private PoliciaService policiaService;

    @PostMapping("/policia")
    @ResponseStatus(HttpStatus.CREATED)
    public PoliciaExibirDto gravar(@RequestBody @Valid PoliciaCadastroDto policia) {
        return policiaService.gravarPolicia(policia);
    }

    @GetMapping("/policia")
    @ResponseStatus(HttpStatus.OK)
    public List<PoliciaExibirDto> litarTodos() {
        return policiaService.listarTodos();
    }

    @PutMapping("/policia")
    @ResponseStatus(HttpStatus.OK)
    public Policia atualizar(@RequestBody @Valid Policia policia){
        return policiaService.atualizar(policia);
    }

    @DeleteMapping("/policia/excluir/{idPolicial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idPolicial){
        policiaService.excluir(idPolicial);
    }


    @GetMapping("/policia/{idPolicia}")
    public ResponseEntity<PoliciaExibirDto> buscarPorId(@PathVariable Long idPolicial) {
        return ResponseEntity.ok(policiaService.buscarPorId(idPolicial));
    }

    @GetMapping("/policia/cargo/{cargo}")
    @ResponseStatus(HttpStatus.OK)
    public PoliciaExibirDto buscarPorCargo(@PathVariable String cargo) {
        return policiaService.buscarPorCargo(cargo);
    }

    @GetMapping("/policia/dp/{departamento}")
    @ResponseStatus(HttpStatus.OK)
    public PoliciaExibirDto buscarPorDepartamento(@PathVariable String departamento) {
        return policiaService.buscarPorDepartamento(departamento);
    }
}
