package br.com.audrin.library.repository;

import br.com.audrin.library.domain.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

}
