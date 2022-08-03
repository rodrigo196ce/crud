package br.com.crud.beta.controller;

import br.com.crud.beta.dto.CadastroDto;
import br.com.crud.beta.dto.EditarDto;
import br.com.crud.beta.enums.Cidade;
import br.com.crud.beta.model.User;
import br.com.crud.beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("editar")
public class EditarController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String editar(HttpServletRequest request, EditarDto editarDto){
        User user = userService.findById(request.getParameter("id"));
        editarDto = this.userService.findByIdAndAttributes(user,editarDto);
        request.setAttribute("cidades", Cidade.values());
        return "editar/editar.html";
    }

    @PostMapping("validarEdicao")
    public String validarEdicao(@Valid EditarDto editarDto, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("cidades",Cidade.values());
            return "editar/editar.html";
        }
        User user = userService.findById(editarDto.getId().toString());
        this.userService.realizarEdicao(user,editarDto);
        return "redirect:/editar/goToViewPage";
    }

    @GetMapping("goToViewPage")
    public ModelAndView goToViewPage(ModelAndView modelAndView){
        modelAndView.setViewName("home/home.html");
        modelAndView.addObject("successEdicao","Edição realizada com sucesso.");
        return modelAndView;
    }


}
