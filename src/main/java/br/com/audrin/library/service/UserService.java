package br.com.audrin.library.service;

import br.com.audrin.library.domain.User;
import br.com.audrin.library.repository.UserRepository;

public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already registered!");
        }
        return userRepository.save(user);
    }
}
