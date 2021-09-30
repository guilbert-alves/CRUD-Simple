package br.gov.ac.sefaz.crud.rh.Controler;

import br.gov.ac.sefaz.crud.rh.dominio.Pessoa;
import br.gov.ac.sefaz.crud.rh.dominio.PessoaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PessoaControler {

    private PessoaRepositorio pessoaRepo;

    public PessoaControler(PessoaRepositorio pessoaRepo){
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping( path = "/rh/pessoas")
    public String pessoas(Model model){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/rh/pessoas/index");
        model.addAttribute("listaPessoas", pessoaRepo.findAll());
        return "rh/pessoas/index";
    }

    @GetMapping(path = "/rh/pessoas/nova")
    public String novaPessoa(@ModelAttribute("pessoa") Pessoa pessoa){
        return "rh/pessoas/form";
    }

    @PostMapping(path = "rh/pessoa/salvar")
    public String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
        pessoaRepo.save(pessoa);
        return "redirect:/rh/pessoas";

    }

    @GetMapping(path = "/rh/pessoas/{id}")
    public String alterarPessoa(@PathVariable("id") long id, Model model){
        Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
        if (pessoaOpt.isEmpty()){
            throw new IllegalArgumentException("não encontrou");
        }

        model.addAttribute("pessoa", pessoaOpt.get());
        return "rh/pessoas/form";

    }

    @GetMapping(path = "/rh/pessoas/excluir/{id}")
    public String excluirPessoa(@PathVariable("id") long id, Model model){
        Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
        if (pessoaOpt.isEmpty()){
            throw new IllegalArgumentException("não encontrou");
        }

        pessoaRepo.delete(pessoaOpt.get());
        return "redirect:/rh/pessoas";

    }

}
