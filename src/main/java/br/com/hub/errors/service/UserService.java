package br.com.hub.errors.service;

import br.com.hub.errors.model.User;
import br.com.hub.errors.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(UUID id){ return userRepository.findById(id); }
    public List<User> findAll(){ return userRepository.findAll(); }
    public User registerUser(User user) { return userRepository.save(user); }

}
