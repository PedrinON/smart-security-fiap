package br.com.fiap.SmartSecurity.service;

import br.com.fiap.SmartSecurity.dto.PoliciaCadastroDto;
import br.com.fiap.SmartSecurity.dto.PoliciaExibirDto;
import br.com.fiap.SmartSecurity.exception.PolicialNaoEncontradoException;
import br.com.fiap.SmartSecurity.model.Policia;
import br.com.fiap.SmartSecurity.repository.PoliciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PoliciaService {

    @Autowired
    private PoliciaRepository policiaRepository;

    public PoliciaExibirDto gravarPolicia(PoliciaCadastroDto policiaCadastroDto) {

        Policia policia = new Policia();
        BeanUtils.copyProperties(policiaCadastroDto, policia);

        Policia policiaSalvo = policiaRepository.save(policia);

        return new PoliciaExibirDto(policiaSalvo);
    }

    public List<PoliciaExibirDto> listarTodos() {
        return policiaRepository
                .findAll()
                .stream()
                .map(PoliciaExibirDto::new)
                .toList();
    }

    public Policia atualizar(Policia policia) {
        Optional<Policia> policiaOptional =
                policiaRepository.findById(policia.getIdPolicial());

        if (policiaOptional.isPresent()) {
            return policiaRepository.save(policia);
        } else {
            throw new RuntimeException("Policial não encontrado!");
        }
    }

    public PoliciaExibirDto buscarPorId(Long id) {
        Optional<Policia> policiaOptional =
                policiaRepository.findById(id);
        if (policiaOptional.isPresent()) {
            return new PoliciaExibirDto(policiaOptional.get());
        } else {
            throw new PolicialNaoEncontradoException("Policial não existe no banco de dados!");
        }
    }

    public void excluir(Long id) {
        Optional<Policia> policiaOptional =
                policiaRepository.findById(id);

        if (policiaOptional.isPresent()) {
            policiaRepository.delete(policiaOptional.get());
        } else {
            throw new RuntimeException("Policial não encontrado!");
        }
    }

    public PoliciaExibirDto buscarPorCargo(String cargo) {
        Optional<Policia> policiaOptional = policiaRepository.findByCargo(cargo);

        if (policiaOptional.isPresent()) {
            return new PoliciaExibirDto(policiaOptional.get());
        } else {
            throw new PolicialNaoEncontradoException("Policial não encontrado!!");
        }
    }

    public PoliciaExibirDto buscarPorDepartamento(String departamento) {
        Optional<Policia> policiaOptional = policiaRepository.findByDepartamento(departamento);

        if (policiaOptional.isPresent()) {
            return new PoliciaExibirDto(policiaOptional.get());
        } else {
            throw new PolicialNaoEncontradoException("Policial não encontrado!!");
        }
    }
}
