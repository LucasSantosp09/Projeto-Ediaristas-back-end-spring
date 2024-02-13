package br.com.treinaweb.ediaristas.models;

import br.com.treinaweb.ediaristas.converters.CepConverts;
import br.com.treinaweb.ediaristas.converters.CpfConverts;
import br.com.treinaweb.ediaristas.converters.TelefoneConverts;
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
    private String nomeCompleto;

    @NotNull
    @Size(min = 11, max = 14)
    @CPF
    @Column(nullable = false, unique = true, length = 11)
    @Convert(converter = CpfConverts.class)
    private String cpf;

    @NotNull
    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 11, max = 15)
    @Column(nullable = false, length = 11)
    @Convert(converter = TelefoneConverts.class)
    private String telefone;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String logradouro;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String numero;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String bairro;

    @Column(nullable = true)
    private String complemento;

    @NotNull
    @Size(min = 8, max = 9)
    @Column(nullable = false, length = 8)
    @Convert(converter = CepConverts.class)
    private String cep;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String cidade;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false)
    private String codigoIbge;

    @Column(nullable = false)
    private String foto;

}
