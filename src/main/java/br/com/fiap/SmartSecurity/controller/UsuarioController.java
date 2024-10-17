package br.com.fiap.SmartSecurity.controller;

import br.com.fiap.SmartSecurity.dto.CrimeExibirDto;
import br.com.fiap.SmartSecurity.dto.UsuarioCadastroDto;
import br.com.fiap.SmartSecurity.dto.UsuarioExibirDto;
import br.com.fiap.SmartSecurity.model.Usuario;
import br.com.fiap.SmartSecurity.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibirDto gravar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        return service.gravar(usuarioCadastroDto);
    }

    @PutMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        return service.atualizar(usuarioCadastroDto);
    }

    @DeleteMapping("/usuario/excluir/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idUsuario){
        service.excluir(idUsuario);
    }
    @GetMapping("/usuario/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibirDto buscarPorId(@PathVariable Long idUsuario){
        return service.buscarPorId(idUsuario);
    }

    @GetMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibirDto> listarTodos(){
        return service.listarTodos();
    }
}
