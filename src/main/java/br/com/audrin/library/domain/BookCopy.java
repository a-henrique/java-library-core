package br.com.audrin.library.domain;

public class BookCopy {
    private Long id;
    private Book book;
    private BookCopyStatus status;

    public BookCopy(Long id, Book book){
        this.id = id;
        this.book = book;
        this.status = BookCopyStatus.AVAILABLE;
    }

    public void borrow(){
        if (status == BookCopyStatus.BORROWED){
            throw new IllegalStateException(
                    "The Copy's already borrowed"
            );
        }
        status = BookCopyStatus.BORROWED;
    }

    public void returnCopy(){
        if (status == BookCopyStatus.AVAILABLE){
            throw new IllegalStateException(
                    "The Copy's already available"
            );
        }
        status = BookCopyStatus.AVAILABLE;
    }

    public Long getId(){
        return id;
    }

    public Book getBook(){
        return book;
    }

    public BookCopyStatus getStatus(){
        return status;
    }
}

