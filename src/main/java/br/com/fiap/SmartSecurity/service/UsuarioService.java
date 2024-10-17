package br.com.fiap.SmartSecurity.service;

import br.com.fiap.SmartSecurity.dto.PoliciaCadastroDto;
import br.com.fiap.SmartSecurity.dto.PoliciaExibirDto;
import br.com.fiap.SmartSecurity.dto.UsuarioCadastroDto;
import br.com.fiap.SmartSecurity.dto.UsuarioExibirDto;
import br.com.fiap.SmartSecurity.exception.PolicialNaoEncontradoException;
import br.com.fiap.SmartSecurity.model.Patrulha;
import br.com.fiap.SmartSecurity.model.Policia;
import br.com.fiap.SmartSecurity.model.Usuario;
import br.com.fiap.SmartSecurity.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibirDto gravar(UsuarioCadastroDto usuarioCadastroDto) {

        String senhaCryptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCryptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioExibirDto(usuarioSalvo);
    }

    public Usuario atualizar(UsuarioCadastroDto usuarioCadastroDto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getIdUsuario());

        if (usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new PolicialNaoEncontradoException("Usuário não encontrada!");
        }
    }

    public void excluir(Long idUsuario) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(idUsuario);

        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public List<UsuarioExibirDto> listarTodos() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibirDto::new)
                .toList();
    }

    public UsuarioExibirDto buscarPorId(Long idUsuario) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            return new UsuarioExibirDto(usuarioOptional.get());
        } else {
            throw new PolicialNaoEncontradoException("Usuário não encontrado!");
        }
    }
}
