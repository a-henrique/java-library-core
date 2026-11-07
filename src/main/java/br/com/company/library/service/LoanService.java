package br.com.company.library.service;

import br.com.company.library.domain.BookCopy;
import br.com.company.library.domain.Loan;
import br.com.company.library.domain.User;
import br.com.company.library.repository.BookCopyRepository;
import br.com.company.library.repository.LoanRepository;
import br.com.company.library.repository.UserRepository;

import java.time.Duration;
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
        bookCopy.borrow();
        Loan loan = new Loan(user, bookCopy, returnPreviewDate);
        return loanRepository.save(loan);
    }

    public Loan returnLoan(UUID loanId){
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        loan.setBookReturnRealDate(LocalDateTime.now());

        Duration delay = Duration.between(loan.getBookReturnPreviewDate(), loan.getBookReturnRealDate());
        Long diasAtraso = delay.toDays();

        if (loan.getBookReturnRealDate().isAfter(loan.getBookReturnPreviewDate())){
            System.out.println("Livro devolvido atrasado");
            double multa = diasAtraso * 1.00 * 1;
            System.out.printf("Total em Multa=R$%.2f\n", multa);

        }
        BookCopy bookCopy = loan.getBookCopy();
        bookCopy.returnCopy();
        loan.finishLoan();
        return loanRepository.save(loan);
    }

    public List<Loan> getUserHistory(Long userId){
        userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return loanRepository.findByUserId(userId);
    }

    public double bookDeadlineEndedCalculate(){
        // TODO
        return 0;
    }
}
