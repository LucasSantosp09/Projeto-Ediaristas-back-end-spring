package br.com.treinaweb.ediaristas.controller;

import br.com.treinaweb.ediaristas.models.Diaristas;
import br.com.treinaweb.ediaristas.repository.DiaristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/diaristas-cidade")
public class DiaristaRestController {
    @Autowired
    private DiaristaRepository diaristaRepository;

    @GetMapping
    public List<Diaristas> buscarDiaristasPorCep(){
        return diaristaRepository.findAll();
    }
}
