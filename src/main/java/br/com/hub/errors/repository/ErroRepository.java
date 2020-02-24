package br.com.hub.errors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.hub.errors.model.Erro;

public interface ErroRepository extends JpaRepository<Erro, Long> {
}

