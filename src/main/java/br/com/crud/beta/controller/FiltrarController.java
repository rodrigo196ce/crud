package br.com.crud.beta.controller;

import br.com.crud.beta.dto.FiltroDto;
import br.com.crud.beta.enums.Cidade;
import br.com.crud.beta.model.User;
import br.com.crud.beta.service.FiltroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("filtrar")
public class FiltrarController {

    @Autowired
    FiltroService filtroService;

    @GetMapping("/")
    public String filtrar(Model model, FiltroDto filtroDto){
        model.addAttribute("cidades",Cidade.values());
        return "filtrar/filtrar.html";
    }

    @PostMapping("realizar")
    public String realizar(FiltroDto filtroDto, Model model) {
        LocalDate localDate = null;
        if (!filtroDto.getDataNascimento().isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            localDate = LocalDate.parse(filtroDto.getDataNascimento(), formatter);
        }

        List<User> lista = this.filtroService
                .filtrar(filtroDto.getNome(), localDate, filtroDto.getEmail(), filtroDto.getTelefone(), filtroDto.getCidade());

        model.addAttribute("lista", lista);
        model.addAttribute("cidades",Cidade.values());
        return "filtrar/filtrar.html";
    }

}
