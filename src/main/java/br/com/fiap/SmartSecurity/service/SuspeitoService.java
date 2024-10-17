package br.com.fiap.SmartSecurity.service;

import br.com.fiap.SmartSecurity.dto.*;
import br.com.fiap.SmartSecurity.exception.PolicialNaoEncontradoException;
import br.com.fiap.SmartSecurity.model.Patrulha;
import br.com.fiap.SmartSecurity.model.Suspeito;
import br.com.fiap.SmartSecurity.repository.SuspeitoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuspeitoService {
    @Autowired
    private SuspeitoRepository suspeitoRepository;

    public SuspeitoExibirDto gravarSuspeito(SuspeitoCadastroDto suspeitoCadastroDto) {

        Suspeito suspeito = new Suspeito();
        BeanUtils.copyProperties(suspeitoCadastroDto, suspeito);

        Suspeito suspeitoSalvo = suspeitoRepository.save(suspeito);

        return new SuspeitoExibirDto(suspeitoSalvo);
    }

    public Suspeito atualizar(SuspeitoCadastroDto suspeitoCadastroDto){
        Suspeito suspeito = new Suspeito();
        BeanUtils.copyProperties(suspeitoCadastroDto, suspeito);
        Optional<Suspeito> suspeitoOptional = suspeitoRepository.findById(suspeito.getIdSuspeito());

        if (suspeitoOptional.isPresent()){
            return suspeitoRepository.save(suspeito);
        } else {
            throw new PolicialNaoEncontradoException("Suspeito não encontrado!");
        }
    }
    public SuspeitoExibirDto buscarPorId(Long idSuspeito){
        Optional<Suspeito> suspeitoOptional = suspeitoRepository.findById(idSuspeito);

        if (suspeitoOptional.isPresent()){
            return new SuspeitoExibirDto(suspeitoOptional.get());
        } else
            throw new PolicialNaoEncontradoException("Suspeito não encontrado!!");
    }
    public SuspeitoExibirDto buscarPorNome(String nome){
        Optional<Suspeito> suspeitoOptional = suspeitoRepository.findByNome(nome);

        if (suspeitoOptional.isPresent()){
            return new SuspeitoExibirDto(suspeitoOptional.get());
        } else
            throw new PolicialNaoEncontradoException("Suspeito não encontrado!!");
    }
}
