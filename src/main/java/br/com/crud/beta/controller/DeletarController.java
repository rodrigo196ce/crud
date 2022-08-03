package br.com.crud.beta.controller;

import br.com.crud.beta.model.User;
import br.com.crud.beta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("deletar")
public class DeletarController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String deletar(HttpServletRequest request){
        User user = this.userService.findById(request.getParameter("id"));
        this.userService.deletar(user);
        return "redirect:/deletar/goToViewPage";
    }

    @GetMapping("goToViewPage")
    public ModelAndView goToViewPage(ModelAndView modelAndView){
        modelAndView.setViewName("home/home.html");
        modelAndView.addObject("successDelete","Cadastro deletado com sucesso.");
        return modelAndView;
    }

}
