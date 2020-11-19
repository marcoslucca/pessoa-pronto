package br.com.fundatec.pessoa.service;

import br.com.fundatec.pessoa.domain.Pessoa;
import br.com.fundatec.pessoa.exceptions.DuplicatedCpfException;
import br.com.fundatec.pessoa.exceptions.InvalidCpfException;
import br.com.fundatec.pessoa.gateway.cpf.CpfGateway;
import br.com.fundatec.pessoa.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CpfGateway cpfGateway;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {

        if(cpfGateway.existsPendencia(pessoa.getCpf())) {
            throw new InvalidCpfException("There are some pendencies in the Federal Revenue for this CPF");
        }

        if(pessoaRepository.existsByCpf(pessoa.getCpf())) {
            throw new DuplicatedCpfException("Cpf already exists");
        }

        return pessoaRepository.saveAndFlush(pessoa);
    }

}
