package br.com.treinaweb.ediaristas.controller;

import br.com.treinaweb.ediaristas.models.Diaristas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin/diaristas")
public class DiaristaController {

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        var modelAndView = new ModelAndView("admin/diaristas/form");
        modelAndView.addObject("diaristas", new Diaristas());
        return modelAndView;
    }
}
