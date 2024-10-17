package br.com.fiap.SmartSecurity.service;

import br.com.fiap.SmartSecurity.dto.CrimeCadastroDto;
import br.com.fiap.SmartSecurity.dto.CrimeExibirDto;
import br.com.fiap.SmartSecurity.exception.PolicialNaoEncontradoException;
import br.com.fiap.SmartSecurity.model.Crime;
import br.com.fiap.SmartSecurity.repository.CrimeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public CrimeExibirDto gravarCrime(CrimeCadastroDto crimeCadastroDto) {

        Crime crime = new Crime();
        BeanUtils.copyProperties(crimeCadastroDto, crime);

        Crime crimeSalvo = crimeRepository.save(crime);

        return new CrimeExibirDto(crimeSalvo);
    }

    public Crime atualizar(CrimeCadastroDto crimeCadastroDto){
        Crime crime = new Crime();
        BeanUtils.copyProperties(crimeCadastroDto, crime);
        Optional<Crime> patrulhaOptional = crimeRepository.findById(crime.getIdCrime());

        if (patrulhaOptional.isPresent()){
            return crimeRepository.save(crime);
        } else {
            throw new PolicialNaoEncontradoException("Crime não encontrado!!");
        }
    }
    public CrimeExibirDto buscarPorId(Long idCrime){
        Optional<Crime> crimeOptional = crimeRepository.findById(idCrime);

        if (crimeOptional.isPresent()){
            return new CrimeExibirDto(crimeOptional.get());
        } else
            throw new PolicialNaoEncontradoException("Crime não encontrado!!");
    }
    public Page<CrimeExibirDto> listarTodosCrimes(Pageable paginacao){
        return crimeRepository.findAll(paginacao).map(CrimeExibirDto::new);
    }

}
