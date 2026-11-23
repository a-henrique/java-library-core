package br.com.company.library.repository;

import br.com.company.library.domain.BookCopy;
import br.com.company.library.domain.BookCopyStatus;

import java.util.List;
import java.util.Optional;

public interface BookCopyRepository {

    BookCopy save(BookCopy bookCopy);

    Optional<BookCopy> findById(Long id);

    List<BookCopy> findAll();

    //
    List<BookCopy> findByStatus(BookCopyStatus status);
}