package br.com.hub.errors.repository;

import java.util.List;

import javax.transaction.Transactional;

import br.com.hub.errors.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserDetailsRepository extends CrudRepository<UserInfo, String> {
    public UserInfo findByUserEmailAndEnabled(String userEmail, short enabled);

    public List<UserInfo> findAllByEnabled(short enabled);

    public UserInfo findById(Integer id);

    void deleteById(Integer id);
}
