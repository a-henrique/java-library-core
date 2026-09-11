package br.com.company.library.domain;

import java.time.LocalDateTime;
public class Loan {
    private Long id;
    private User user;
    private BookCopy bookCopy;
    private LocalDateTime loanStart;
    private LocalDateTime bookReturnPreviewDate;
    private LocalDateTime bookReturnRealDate;
    private LoanStatus status;

    public Loan(Long id, User user, BookCopy bookCopy, LocalDateTime bookReturnPreviewDate){
        this.id = id;
        this.user = user;
        this.bookCopy = bookCopy;
        this.bookReturnPreviewDate = bookReturnPreviewDate;
        this.bookReturnRealDate = null;
        this.status = LoanStatus.ACTIVE;
        this.loanStart = LocalDateTime.now();
    }

    public Long getId(){
        return this.id;
    }
    public User getUser(){
        return user;
    }

    public BookCopy getBookCopy(){
        return bookCopy;
    }

    public LocalDateTime getBookReturnPreviewDate(){
        return bookReturnPreviewDate;
    }

    public LocalDateTime getBookReturnRealDate(){
        return bookReturnRealDate;
    }

    public LoanStatus getStatus(){
        return status;
    }

    public void finishLoan(){
        if (status == LoanStatus.FINISHED){
            throw new IllegalStateException("Loan Already finished");
        }
        this.status = LoanStatus.FINISHED;
        this.bookReturnRealDate = LocalDateTime.now();
    }
}
