package br.com.audrin.library.domain;

public class Book {
    private Long id;
    private String title;
    private String isbn;
    private String author;

    public Book(Long id, String title, String isbn, String author){
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public Long getId(){
        return id;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getAuthor(){
        return author;
    }
}
