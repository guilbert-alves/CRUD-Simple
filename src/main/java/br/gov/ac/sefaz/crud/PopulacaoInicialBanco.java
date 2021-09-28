package br.gov.ac.sefaz.crud;

import br.gov.ac.sefaz.crud.rh.dominio.Pessoa;
import br.gov.ac.sefaz.crud.rh.dominio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

    @Autowired
    private PessoaRepositorio pessoaRepo;

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa("Joao");
        p1.setDataNacimento(LocalDate.of(1990,04,01));
        p1.setEmail("joao@gmail.com");
        p1.setTelefone(("99605334"));
        Pessoa p2 = new Pessoa("Maria");
        p2.setCpf("03.183.962.00");
        p2.setDataNacimento(LocalDate.of(2000,12,06));
        p2.setEmail("maria@gmail.com");

        pessoaRepo.save(p1);
        pessoaRepo.save(p2);

    }
}
