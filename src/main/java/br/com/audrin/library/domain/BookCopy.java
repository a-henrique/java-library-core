package br.com.audrin.library.domain;

public class BookCopy {
    private Long id;
    private Book book;
    private BookCopyStatus status;

    BookCopy(Long id, Book book, BookCopyStatus status){
        this.id = id;
        this.book = book;
        this.status = status;
    }

    public void borrow() {}

    public void returnCopy(){}
}

