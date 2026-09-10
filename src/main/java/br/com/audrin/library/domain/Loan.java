package br.com.audrin.library.domain;

import java.util.Date;

public class Loan {
    private Long id;
    private User user;
    private BookCopy bookCopy;
    private Date bookReturnPreviewDate;
    private Date bookReturnRealDate;
    private LoanStatus status;

    public Loan(Long id, User user, BookCopy bookCopy, Date bookReturnPreviewDate){
        this.id = id;
        this.user = user;
        this.bookCopy = bookCopy;
        this.bookReturnPreviewDate = bookReturnPreviewDate;
        this.bookReturnRealDate = null;
        this.status = LoanStatus.ACTIVE;
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

    public Date getBookReturnPreviewDate(){
        return bookReturnPreviewDate;
    }

    public Date getBookReturnRealDate(){
        return bookReturnRealDate;
    }

    public LoanStatus getStatus(){
        return status;
    }

    public void returnLoan(Date returnDate){
        if (status == LoanStatus.RETURNED){
            throw new IllegalStateException("Loan already returned");
        }

        this.bookReturnRealDate = returnDate;
        this.status = LoanStatus.RETURNED;
    }
}
