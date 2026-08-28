package br.com.audrin.library.repository.memory;

import br.com.audrin.library.domain.Book;
import br.com.audrin.library.repository.BookRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {

    private final Map<Long, Book> books = new HashMap<>();
    @Override
    public Book save(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Optional<Book> findById(Long id){
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public List<Book> findAll() {
        return List.copyOf(books.values());
    }

    @Override
    public Optional<Book> findByISBN(String isbn){
        return books.values()
                .stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }
}
