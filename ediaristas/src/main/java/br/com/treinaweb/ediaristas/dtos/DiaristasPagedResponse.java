package br.com.treinaweb.ediaristas.dtos;

import br.com.treinaweb.ediaristas.models.Diaristas;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaristasPagedResponse {

    private List<Diaristas> diaristas;

    @JsonProperty("quantidade_diaristas")
    private Long quantidadeDiaristas;


}
