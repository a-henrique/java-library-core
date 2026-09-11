package br.com.company.library.service;

import br.com.company.library.domain.Book;
import br.com.company.library.repository.BookRepository;

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
