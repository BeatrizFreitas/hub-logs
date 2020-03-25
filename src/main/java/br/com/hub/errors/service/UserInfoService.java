package br.com.hub.errors.service;

import java.util.List;

import br.com.hub.errors.model.UserInfo;
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

    public UserInfo getUserInfoByUserEmail(String userEmail) {
        short enabled = 1;
        return userDatailsRepository.findByUserEmailAndEnabled(userEmail, enabled);
    }

    public UserInfo getUserByUserId(Integer id) {
        return userDatailsRepository.findById(id);
    }

    public List<UserInfo> getAllActiveUserInfo() {
        return userDatailsRepository.findAllByEnabled((short) 1);
    }

    public UserInfo addUser(UserInfo userInfo) {
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        return userDatailsRepository.save(userInfo);
    }

    public void deleteUser(Integer id) {
        userDatailsRepository.deleteById(id);
    }

    public UserInfo updatePassword(Integer id, UserInfo userRecord) {
        UserInfo userInfo = userDatailsRepository.findById(id);
        userInfo.setPassword(userRecord.getPassword());
        return userDatailsRepository.save(userInfo);
    }

    public UserInfo updateRole(Integer id, UserInfo userRecord) {
        UserInfo userInfo = userDatailsRepository.findById(id);
        userInfo.setRole(userRecord.getRole());
        return userDatailsRepository.save(userInfo);
    }
}
