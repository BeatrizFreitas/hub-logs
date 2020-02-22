package br.com.hub.errors.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.hub.errors.model.Erro;

public interface ErroRepository extends CrudRepository<Erro, Long> {
}

