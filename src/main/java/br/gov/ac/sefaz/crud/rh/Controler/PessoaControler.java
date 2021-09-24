package br.gov.ac.sefaz.crud.rh.Controler;

import br.gov.ac.sefaz.crud.rh.dominio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaControler {




    private PessoaRepositorio pessoaRepo;

    public PessoaControler(PessoaRepositorio pessoaRepo){
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping("/rh/pessoas")
    public String pessoas(Model model){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        model.addAttribute("listaPessoas", pessoaRepo.findAll());
        return "/index";
    }


    @GetMapping("/")
    public String hello(){
        return "TESTE";

    }

}
