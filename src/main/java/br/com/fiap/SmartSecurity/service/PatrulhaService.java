package br.com.fiap.SmartSecurity.service;

import br.com.fiap.SmartSecurity.dto.*;
import br.com.fiap.SmartSecurity.exception.PolicialNaoEncontradoException;
import br.com.fiap.SmartSecurity.model.Patrulha;
import br.com.fiap.SmartSecurity.repository.PatrulhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class PatrulhaService {
    @Autowired
    private PatrulhaRepository patrulhaRepository;

    public PatrulhaExibirDto gravarPatrulha(PatrulhaCadastroDto patrulhaCadastroDto) {

        Patrulha patrulha = new Patrulha();
        BeanUtils.copyProperties(patrulhaCadastroDto, patrulha);

        Patrulha patrulhaSalvo = patrulhaRepository.save(patrulha);

        return new PatrulhaExibirDto(patrulhaSalvo);
    }

    public Patrulha atualizar(PatrulhaCadastroDto patrulhaCadastroDto){
        Patrulha patrulha = new Patrulha();
        BeanUtils.copyProperties(patrulhaCadastroDto, patrulha);
        Optional<Patrulha> patrulhaOptional = patrulhaRepository.findById(patrulha.getIdPatrulha());

        if (patrulhaOptional.isPresent()){
            return patrulhaRepository.save(patrulha);
        } else {
            throw new PolicialNaoEncontradoException("Patrulha não encontrada!");
        }
    }
    public PatrulhaExibirDto buscarPorLocalizacao(String localizacao){

        Optional<Patrulha> patrulhaOptional = patrulhaRepository.findByLocalizacao(localizacao);

        if (patrulhaOptional.isPresent()){
            return new PatrulhaExibirDto(patrulhaOptional.get());
        } else {
            throw new PolicialNaoEncontradoException("Patrulha não encontrada!");
        }
    }

    public PatrulhaExibirDto buscarPorDisponibilidade(String disponibilidade){

        Optional<Patrulha> patrulhaOptional = patrulhaRepository.findByDisponibilidade(disponibilidade);

        if (patrulhaOptional.isPresent()){
            return new PatrulhaExibirDto(patrulhaOptional.get());
        } else {
            throw new PolicialNaoEncontradoException("Patrulha não encontrada!");
        }
    }
}
