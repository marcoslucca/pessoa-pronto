package br.com.fundatec.pessoa.service;

import br.com.fundatec.pessoa.Main;
import br.com.fundatec.pessoa.domain.Pessoa;
import br.com.fundatec.pessoa.exceptions.DuplicatedCpfException;
import br.com.fundatec.pessoa.exceptions.InvalidCpfException;
import br.com.fundatec.pessoa.gateway.cpf.CpfGateway;
import br.com.fundatec.pessoa.repository.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @MockBean
    private PessoaRepository pessoaRepository;

    @MockBean
    private CpfGateway cpfGateway;

}