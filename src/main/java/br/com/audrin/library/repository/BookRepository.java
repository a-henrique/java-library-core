package br.com.audrin.library.repository;

import br.com.audrin.library.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();

    boolean existsByIsbn(String isbn);
}
