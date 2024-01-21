package br.com.treinaweb.ediaristas.controller;

import br.com.treinaweb.ediaristas.models.Diaristas;
import br.com.treinaweb.ediaristas.repository.DiaristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/diaristas")
public class DiaristaController {
    @Autowired
    private DiaristaRepository diaristaRepository;

    @GetMapping
    public ModelAndView listar(){
        var modelAndView = new ModelAndView("admin/diaristas/listar");
        modelAndView.addObject("diaristas", diaristaRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        var modelAndView = new ModelAndView("admin/diaristas/form");
        modelAndView.addObject("diaristas", new Diaristas());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Diaristas diaristas){
        diaristaRepository.save(diaristas);
        return "redirect:/admin/diaristas";
    }
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        diaristaRepository.deleteById(id);
        return "redirect:/admin/diaristas";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        var modelAndView = new ModelAndView("admin/diaristas/form");
        modelAndView.addObject("diaristas", diaristaRepository.getById(id));
        return modelAndView;

    }
}
