package br.com.company.library.service;

import br.com.company.library.domain.BookCopy;
import br.com.company.library.domain.Loan;
import br.com.company.library.domain.User;
import br.com.company.library.repository.BookCopyRepository;
import br.com.company.library.repository.LoanRepository;
import br.com.company.library.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    public Loan createLoan(Long userId, Long bookCopyId, LocalDateTime returnPreviewDate){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        BookCopy bookCopy = bookCopyRepository.findById(bookCopyId).orElseThrow(() -> new IllegalArgumentException("Book Copy not found"));;
        Loan loan = new Loan(UUID.randomUUID(),user, bookCopy, returnPreviewDate);
        System.out.println(loan.getId());
        bookCopy.borrow();
        return loanRepository.save(loan);
    }

    public Loan returnLoan(UUID loanId){
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        BookCopy bookCopy = loan.getBookCopy();
        bookCopy.returnCopy();
        loan.finishLoan();
        return loanRepository.save(loan);
    }

    public List<Loan> getUserHistory(Long userId){
        userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return loanRepository.findByUserId(userId);
    }
}
