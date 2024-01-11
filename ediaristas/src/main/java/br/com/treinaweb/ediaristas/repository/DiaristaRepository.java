package br.com.treinaweb.ediaristas.repository;

import br.com.treinaweb.ediaristas.models.Diaristas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaristaRepository extends JpaRepository<Diaristas, Long> {
}
