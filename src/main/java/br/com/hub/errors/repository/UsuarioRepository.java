package br.com.hub.errors.repository;

import br.com.hub.errors.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {
}
