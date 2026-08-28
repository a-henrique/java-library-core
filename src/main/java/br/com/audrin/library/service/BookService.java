package br.com.audrin.library.service;

import br.com.audrin.library.domain.Book;
import br.com.audrin.library.repository.BookRepository;

import java.util.Optional;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book create(Book book){
        if(bookRepository.findByISBN(book.getIsbn()).isPresent()){
            throw new IllegalArgumentException("ISBN already registered!");
        }
        return bookRepository.save(book);
    }
}
