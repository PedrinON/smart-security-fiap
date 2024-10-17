package br.com.fiap.SmartSecurity.controller;

import br.com.fiap.SmartSecurity.config.security.TokenService;
import br.com.fiap.SmartSecurity.dto.LoginDto;
import br.com.fiap.SmartSecurity.dto.TokenDto;
import br.com.fiap.SmartSecurity.dto.UsuarioCadastroDto;
import br.com.fiap.SmartSecurity.dto.UsuarioExibirDto;
import br.com.fiap.SmartSecurity.model.Usuario;
import br.com.fiap.SmartSecurity.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto){
        UsernamePasswordAuthenticationToken usernamePasswor =
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(),
                        loginDto.senha()
                );

        Authentication auth = authenticationManager.authenticate(usernamePasswor);
        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDto(token));
    }
    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibirDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        UsuarioExibirDto usuarioSalvo = null;
        usuarioSalvo = usuarioService.gravar(usuarioCadastroDto);

        return usuarioSalvo;

    }
}
