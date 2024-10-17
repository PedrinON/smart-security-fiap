package br.com.fiap.SmartSecurity.controller;

import br.com.fiap.SmartSecurity.dto.CrimeCadastroDto;
import br.com.fiap.SmartSecurity.dto.CrimeExibirDto;
import br.com.fiap.SmartSecurity.dto.SuspeitoCadastroDto;
import br.com.fiap.SmartSecurity.dto.SuspeitoExibirDto;
import br.com.fiap.SmartSecurity.model.Crime;
import br.com.fiap.SmartSecurity.model.Suspeito;
import br.com.fiap.SmartSecurity.service.SuspeitoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SuspeitoController {
    @Autowired
    private SuspeitoService suspeitoService;

    @PostMapping("/suspeito")
    @ResponseStatus(HttpStatus.CREATED)
    public SuspeitoExibirDto gravar(@RequestBody @Valid SuspeitoCadastroDto suspeitoCadastroDto){
        return suspeitoService.gravarSuspeito(suspeitoCadastroDto);
    }

    @PutMapping("/suspeito")
    @ResponseStatus(HttpStatus.OK)
    public Suspeito atualizar(@RequestBody @Valid SuspeitoCadastroDto suspeitoCadastroDto){
        return suspeitoService.atualizar(suspeitoCadastroDto);
    }

    @GetMapping("/suspeito/{idSuspeito}")
    @ResponseStatus(HttpStatus.OK)
    public SuspeitoExibirDto buscarPorId(@PathVariable Long idSuspeito){
        return suspeitoService.buscarPorId(idSuspeito);
    }

    @GetMapping("/suspeito/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public SuspeitoExibirDto listarPorNome(@PathVariable String nome){
        return suspeitoService.buscarPorNome(nome);
    }
}
