package br.com.fiap.SmartSecurity.dto;

import br.com.fiap.SmartSecurity.model.Usuario;
import br.com.fiap.SmartSecurity.model.UsuarioRole;

public record UsuarioExibirDto(
        Long idUsuario,
        String nome,
        String email,
        UsuarioRole role
) {
    public UsuarioExibirDto(Usuario usuario) {
        this(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }
}
