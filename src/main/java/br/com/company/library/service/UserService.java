package br.com.company.library.service;

import br.com.company.library.domain.User;
import br.com.company.library.repository.UserRepository;

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

    public String searchUser(String name){
        User user = userRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("User not found!"));

        return user.getName();
    }
}
