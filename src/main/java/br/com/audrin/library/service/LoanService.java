package br.com.audrin.library.service;

import br.com.audrin.library.domain.Loan;
import br.com.audrin.library.repository.BookCopyRepository;
import br.com.audrin.library.repository.LoanRepository;
import br.com.audrin.library.repository.UserRepository;

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


}
