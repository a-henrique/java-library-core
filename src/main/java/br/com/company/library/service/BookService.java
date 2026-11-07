package br.com.company.library.service;

import br.com.company.library.domain.Book;
import br.com.company.library.domain.BookCopy;
import br.com.company.library.repository.BookCopyRepository;
import br.com.company.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
//    private BookCopyRepository bookCopyRepository;

    public BookService(BookRepository bookRepository/*, BookCopyRepository bookCopyRepository */){
        this.bookRepository = bookRepository;
//        this.bookCopyRepository = bookCopyRepository;
    }

    public Book create(Book book){
        if(bookRepository.findByISBN(book.getIsbn()).isPresent()){
            throw new IllegalArgumentException("ISBN already registered!");
        }
        return bookRepository.save(book);
    }

    public String searchBook(String bookTitle){
        Book book = bookRepository.findByTitle(bookTitle).orElseThrow(() -> new IllegalArgumentException("Book Not Found!"));

        return book.getTitle();
    }
}
