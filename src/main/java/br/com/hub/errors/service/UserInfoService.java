package br.com.hub.errors.service;

import java.util.List;

import br.com.hub.errors.model.User;
import br.com.hub.errors.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserInfoService {

    @Autowired
    private UserDetailsRepository userDatailsRepository;

    public User getUserInfoByUserEmail(String userEmail) {
        short enabled = 1;
        return userDatailsRepository.findByUserEmailAndEnabled(userEmail, enabled);
    }

    public User getUserByUserId(Integer id) {
        return userDatailsRepository.findById(id);
    }

    public List<User> getAllActiveUserInfo() {
        return userDatailsRepository.findAllByEnabled((short) 1);
    }

    public User addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userDatailsRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userDatailsRepository.deleteById(id);
    }

    public User updatePassword(Integer id, User userRecord) {
        User user = userDatailsRepository.findById(id);
        user.setPassword(userRecord.getPassword());
        return userDatailsRepository.save(user);
    }

    public User updateRole(Integer id, User userRecord) {
        User user = userDatailsRepository.findById(id);
        user.setRole(userRecord.getRole());
        return userDatailsRepository.save(user);
    }
}
