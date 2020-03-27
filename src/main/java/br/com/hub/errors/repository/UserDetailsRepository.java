package br.com.hub.errors.repository;

import java.util.List;

import javax.transaction.Transactional;

import br.com.hub.errors.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserDetailsRepository extends CrudRepository<User, String> {
    public User findByUserEmailAndEnabled(String userEmail, short enabled);

    public List<User> findAllByEnabled(short enabled);

    public User findById(Integer id);

    void deleteById(Integer id);
}
