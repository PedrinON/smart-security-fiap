package br.com.fiap.SmartSecurity.controller;

import br.com.fiap.SmartSecurity.dto.PatrulhaCadastroDto;
import br.com.fiap.SmartSecurity.dto.PatrulhaExibirDto;
import br.com.fiap.SmartSecurity.model.Patrulha;
import br.com.fiap.SmartSecurity.service.PatrulhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PatrulhaController {
    @Autowired
    private PatrulhaService patrulhaService;
    @PostMapping("/patrulha")
    @ResponseStatus(HttpStatus.CREATED)
    public PatrulhaExibirDto gravar(@RequestBody @Valid PatrulhaCadastroDto patrulhaCadastroDto){
        return patrulhaService.gravarPatrulha(patrulhaCadastroDto);
    }
    @PutMapping("/patrulha")
    @ResponseStatus(HttpStatus.OK)
    public Patrulha atualizar(@RequestBody @Valid PatrulhaCadastroDto patrulhaCadastroDto){
        return patrulhaService.atualizar(patrulhaCadastroDto);
    }
    @GetMapping("/patrulha/disponibilidade/{disponibilidade}")
    @ResponseStatus(HttpStatus.OK)
    public PatrulhaExibirDto buscarPorDisponibilidade(@PathVariable String disponibilidade){
        return patrulhaService.buscarPorDisponibilidade(disponibilidade);
    }
    @GetMapping("/patrulha/loc/{localizacao}")
    @ResponseStatus(HttpStatus.OK)
    public PatrulhaExibirDto buscarPorLocalizacao(@PathVariable String localizacao){
        return patrulhaService.buscarPorLocalizacao(localizacao);
    }
}
