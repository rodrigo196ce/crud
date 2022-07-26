package br.com.crud.beta.controller;

import br.com.crud.beta.dto.CadastroDto;
import br.com.crud.beta.enums.Cidade;
import br.com.crud.beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("cadastrar")
public class CadastrarController {

    @Autowired
    UserService userService;

    @RequestMapping()
    public String cadastrar(CadastroDto cadastroDto, Model model){
        model.addAttribute("cidades", Cidade.values());
        return "cadastrar/cadastrar.html";
    }
    @PostMapping("validarCadastro")
    public String validarCadastro(@Valid CadastroDto cadastroDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("cidades", Cidade.values());
            return "cadastrar/cadastrar.html";
        }
        userService.save(cadastroDto.ToCadastro());
        return "redirect:/cadastrar/goToViewPage";
    }

    @GetMapping("goToViewPage")
    public ModelAndView finalizarCadastro(){
        ModelAndView modelAndView = new ModelAndView("home/home.html");
        modelAndView.addObject("success","Cadastro realizado com sucesso.");
        return modelAndView;
    }

}
