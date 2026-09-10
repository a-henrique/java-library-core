package br.com.audrin.library.service;

import br.com.audrin.library.domain.BookCopy;
import br.com.audrin.library.domain.Loan;
import br.com.audrin.library.domain.User;
import br.com.audrin.library.repository.BookCopyRepository;
import br.com.audrin.library.repository.LoanRepository;
import br.com.audrin.library.repository.UserRepository;

import java.util.Date;
import java.util.Optional;

public class LoanService {
    // It necessary to check:
    //  1. if user exists
    //  2. if bookCopy exists
    //  3. change bookCopy status to BORROWED
    // For last create and save the Loan

    private UserRepository userRepository;
    private BookCopyRepository bookCopyRepository;
    private LoanRepository loanRepository;

    public LoanService(UserRepository userRepository, BookCopyRepository bookCopyRepository, LoanRepository loanRepository){
        this.userRepository = userRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.loanRepository = loanRepository;
    }

    public Loan createLoan(Long userId, Long bookCopyId, Date returnPreviewDate){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        BookCopy bookCopy = bookCopyRepository.findById(bookCopyId).orElseThrow(() -> new IllegalArgumentException("Book Copy not found"));

        bookCopy.borrow();

        Loan loan = new Loan(1L, user, bookCopy, returnPreviewDate);
        return loanRepository.save(loan);
    }

    public Loan returnLoan(Long loanId, Date returnDate){
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        BookCopy bookCopy = loan.getBookCopy();
        bookCopy.returnCopy();
        loan.returnLoan(returnDate);

        return loanRepository.save(loan);
    }
}
