package br.com.audrin.library.repository.memory;

import br.com.audrin.library.domain.User;
import br.com.audrin.library.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private final Map<Long, User> users = new HashMap<>();

    @Override
    public User save(User user){
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id){
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> findAll(){
        return List.copyOf(users.values());
    }

    @Override
    public Optional<User> findByEmail(String email){
        return users.values()
                .stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
