package br.com.audrin;

import br.com.audrin.library.domain.User;
import br.com.audrin.library.repository.UserRepository;
import br.com.audrin.library.repository.memory.InMemoryUserRepository;
import br.com.audrin.library.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        User user1 = new User(1L, "Audrin", "audrin@123.com");
        User user2 = new User(2L, "Outro Audrin", "audrin@123.com");

        userService.create(user1);
        System.out.println("Usuario 1 cadastrado");
        try {
            userService.create(user2);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}