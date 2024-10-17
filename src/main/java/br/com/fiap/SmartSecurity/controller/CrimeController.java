package br.com.fiap.SmartSecurity.controller;

import br.com.fiap.SmartSecurity.dto.CrimeCadastroDto;
import br.com.fiap.SmartSecurity.dto.CrimeExibirDto;
import br.com.fiap.SmartSecurity.model.Crime;
import br.com.fiap.SmartSecurity.service.CrimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CrimeController {
    @Autowired
    private CrimeService crimeService;
    @PostMapping("/crime")
    @ResponseStatus(HttpStatus.CREATED)
    public CrimeExibirDto gravarCrime(@RequestBody @Valid CrimeCadastroDto crimeCadastroDto){
        return crimeService.gravarCrime(crimeCadastroDto);
    }

    @PutMapping("/crime")
    @ResponseStatus(HttpStatus.OK)
    public Crime atualizarCrime(@RequestBody @Valid CrimeCadastroDto crimeCadastroDto){
        return crimeService.atualizar(crimeCadastroDto);
    }

    @GetMapping("/crime/{idCrime}")
    @ResponseStatus(HttpStatus.OK)
    public CrimeExibirDto buscarPorIdCrime(@PathVariable Long idCrime){
        return crimeService.buscarPorId(idCrime);
    }

    @GetMapping("/crime")
    @ResponseStatus(HttpStatus.OK)
    public Page<CrimeExibirDto> listarTodosCrimes(Pageable paginacao){
        return crimeService.listarTodosCrimes(paginacao);
    }

}
