package br.com.treinaweb.ediaristas.controller;

import br.com.treinaweb.ediaristas.models.Diaristas;
import br.com.treinaweb.ediaristas.repository.DiaristaRepository;
import br.com.treinaweb.ediaristas.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/diaristas-cidade")
public class DiaristaRestController {
    @Autowired
    private DiaristaRepository diaristaRepository;

    @Autowired
    private ViaCepService viaCepService;

//    @GetMapping
//    public List<Diaristas> buscarDiaristasPorCep(){
//        return diaristaRepository.findAll();
//    }

    @GetMapping
    public List<Diaristas> buscarDiaristasPorCep(@RequestParam String cep){
       var endereco = viaCepService.buscarEnderecoPorCep(cep);
       var codigoIbge = endereco.getIbge();
       return diaristaRepository.findByCodigoIbge(codigoIbge);

    }
}
