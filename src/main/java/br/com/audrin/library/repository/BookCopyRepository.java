package br.com.audrin.library.repository;

import br.com.audrin.library.domain.BookCopy;

import java.util.List;
import java.util.Optional;

public interface BookCopyRepository {

    BookCopy save(BookCopy bookCopy);

    Optional<BookCopy> findById(Long id);

    List<BookCopy> findAll();

}
