package br.com.company.library.repository;

import br.com.company.library.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();

    Optional<Book> findByISBN(String isbn);
}
