package br.com.treinaweb.ediaristas.controller;

import br.com.treinaweb.ediaristas.models.Diaristas;
import br.com.treinaweb.ediaristas.repository.DiaristaRepository;
import br.com.treinaweb.ediaristas.services.FileService;
import br.com.treinaweb.ediaristas.services.ViaCepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/admin/diaristas")
public class DiaristaController {
    @Autowired
    private DiaristaRepository diaristaRepository;
    @Autowired
    private FileService fileService;
    @Autowired
    private ViaCepService viaCepService;

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
    public String cadastrar(@RequestParam MultipartFile imagem, @Valid Diaristas diaristas, BindingResult result) throws IOException {

        if (result.hasErrors()){
            return "admin/diaristas/form";
        }
        var filename = fileService.salvar(imagem);
        diaristas.setFoto(filename);
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

    @PostMapping("/{id}/editar")
    public String editar(@RequestParam MultipartFile imagem,  @PathVariable Long id,@Valid Diaristas diaristas, BindingResult result) throws IOException {
        if (result.hasErrors()){
            return "admin/diaristas/form";
        }

        var diaristaAtual = diaristaRepository.getById(id);

        if (imagem.isEmpty()){
            diaristas.setFoto(diaristaAtual.getFoto());
        }else {
            var filename = fileService.salvar(imagem);
            diaristas.setFoto(filename);
        }

        diaristaRepository.save(diaristas);
        return "redirect:/admin/diaristas";
    }


}
