package br.com.treinaweb.ediaristas.repository;

import br.com.treinaweb.ediaristas.models.Diaristas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaristaRepository extends JpaRepository<Diaristas, Long> {


    List<Diaristas> findByCodigoIbge(String codigoIbge);
}
