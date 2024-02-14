package br.com.treinaweb.ediaristas.models;

import br.com.treinaweb.ediaristas.controller.FileController;
import br.com.treinaweb.ediaristas.converters.CepConverts;
import br.com.treinaweb.ediaristas.converters.CpfConverts;
import br.com.treinaweb.ediaristas.converters.TelefoneConverts;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.io.IOException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Diaristas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @NotNull
    @Size(min = 11, max = 14)
    @CPF
    @Column(nullable = false, unique = true, length = 11)
    @Convert(converter = CpfConverts.class)
    @JsonIgnore
    private String cpf;

    @NotNull
    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    @JsonIgnore
    private String email;

    @NotNull
    @Size(min = 11, max = 15)
    @Column(nullable = false, length = 11)
    @Convert(converter = TelefoneConverts.class)
    @JsonIgnore
    private String telefone;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    @JsonIgnore
    private String logradouro;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    @JsonIgnore
    private String numero;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    @JsonIgnore
    private String bairro;

    @Column(nullable = true)
    @JsonIgnore
    private String complemento;

    @NotNull
    @Size(min = 8, max = 9)
    @Column(nullable = false, length = 8)
    @Convert(converter = CepConverts.class)
    @JsonIgnore
    private String cep;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String cidade;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(nullable = false, length = 2)
    @JsonIgnore
    private String estado;

    @Column(nullable = false)
    @JsonIgnore
    private String codigoIbge;

    @Column(nullable = false)
    @JsonIgnore
    private String foto;

    @JsonProperty("foto_usuario")
    public String getFotoUrl() throws IOException {
        return linkTo(methodOn(FileController.class).file(foto)).toString();
    }

}
