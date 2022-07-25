package br.com.crud.beta.controller;

import br.com.crud.beta.dto.CadastroDto;
import br.com.crud.beta.enums.Cidade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("cadastrar")
public class CadastrarController {

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

        return null;
    }

}
