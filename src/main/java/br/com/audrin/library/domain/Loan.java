package br.com.audrin.library.domain;

import java.util.Date;

public class Loan {
    private User user;
    private BookCopy bookCopy;
    private Date bookReturnPreviewDate;
    private Date bookReturnRealDate;
    private LoanStatus status;

    public Loan(User user, BookCopy bookCopy, Date bookReturnPreviewDate, Date bookReturnRealDate){
        this.user = user;
        this.bookCopy = bookCopy;
        this.bookReturnPreviewDate = bookReturnPreviewDate;
        this.bookReturnRealDate = bookReturnRealDate;
        this.status = LoanStatus.ACTIVE;
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

    public void returnLoan(){
        this.status = LoanStatus.RETURNED;
    }
}
