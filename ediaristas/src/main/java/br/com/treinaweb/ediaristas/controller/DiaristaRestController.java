package br.com.treinaweb.ediaristas.controller;

import br.com.treinaweb.ediaristas.dtos.DiaristasPagedResponse;

import br.com.treinaweb.ediaristas.repository.DiaristaRepository;
import br.com.treinaweb.ediaristas.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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
    public DiaristasPagedResponse buscarDiaristasPorCep(@RequestParam String cep){
       var endereco = viaCepService.buscarEnderecoPorCep(cep);
       var codigoIbge = endereco.getIbge();
       var pageble = PageRequest.of(0, 6);
       var diaristas = diaristaRepository.findByCodigoIbge(codigoIbge, pageble);

       var quantidadeDiaristas = diaristas.getTotalElements() > 6 ? diaristas.getTotalElements() - 6 : 0;
       return new DiaristasPagedResponse(diaristas.getContent(), quantidadeDiaristas);

    }
}
