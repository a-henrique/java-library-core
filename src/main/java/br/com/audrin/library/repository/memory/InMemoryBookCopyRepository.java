package br.com.audrin.library.repository.memory;

import br.com.audrin.library.domain.Book;
import br.com.audrin.library.domain.BookCopy;
import br.com.audrin.library.repository.BookCopyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryBookCopyRepository implements BookCopyRepository {

    private final Map<Long, BookCopy> bookCopies = new HashMap<>();

    @Override
    public BookCopy save(BookCopy bookCopy){
        bookCopies.put(bookCopy.getId(), bookCopy);
        return bookCopy;
    };

    @Override
    public List<BookCopy> findAll(){
        return List.copyOf(bookCopies.values());
    }

    @Override
    public Optional<BookCopy> findById(Long id){
        return Optional.ofNullable(bookCopies.get(id));
    }
}
