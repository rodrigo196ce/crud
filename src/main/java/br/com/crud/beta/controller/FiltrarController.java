package br.com.crud.beta.controller;

import br.com.crud.beta.dto.FiltroDto;
import br.com.crud.beta.enums.Cidade;
import br.com.crud.beta.model.User;
import br.com.crud.beta.service.FiltroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
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

    @RequestMapping("realizar")
    public String realizar(FiltroDto filtroDto, Model model) {
        LocalDate localDate = null;
        if (!filtroDto.getDataNascimento().isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            localDate = LocalDate.parse(filtroDto.getDataNascimento(), formatter);
        }
        Integer page;
        if(filtroDto.getPage()==null){
            page=0;
        }else{
            page = Integer.valueOf(filtroDto.getPage());
        }
        if(filtroDto.getNome().isBlank()){
            filtroDto.setNome(null);
        }

        Page<User> lista = this.filtroService
                .filtrar(filtroDto.getNome(), localDate, filtroDto.getEmail(), filtroDto.getTelefone(), filtroDto.getCidade(), page);

        int[] arrayTotalPages = new int[lista.getTotalPages()];

        model.addAttribute("lista", lista);
        model.addAttribute("cidades",Cidade.values());
        model.addAttribute("totalPages",arrayTotalPages);
        return "filtrar/filtrar.html";
    }

}
