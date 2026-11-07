package br.com.company;

import br.com.company.library.domain.Book;
import br.com.company.library.domain.BookCopy;
import br.com.company.library.domain.Loan;
import br.com.company.library.domain.User;
import br.com.company.library.repository.BookCopyRepository;
import br.com.company.library.repository.BookRepository;
import br.com.company.library.repository.LoanRepository;
import br.com.company.library.repository.UserRepository;
import br.com.company.library.repository.memory.InMemoryBookCopyRepository;
import br.com.company.library.repository.memory.InMemoryBookRepository;
import br.com.company.library.repository.memory.InMemoryLoanRepository;
import br.com.company.library.repository.memory.InMemoryUserRepository;
import br.com.company.library.service.BookService;
import br.com.company.library.service.LoanService;
import br.com.company.library.service.UserService;

import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        // 1. Criar repositories
        UserRepository userRepository = new InMemoryUserRepository();
        BookRepository bookRepository = new InMemoryBookRepository();
        BookCopyRepository bookCopyRepository = new InMemoryBookCopyRepository();
        LoanRepository loanRepository = new InMemoryLoanRepository();

        // 2. Criar services
        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        LoanService loanService = new LoanService(userRepository, bookCopyRepository, loanRepository);

        Book book = new Book(1L, "ASD", "1234", "AUDRIN");
        bookService.create(book);

        User audrin = new User(1L, "Audrin", "audrin@gmail.com");
        userService.create(audrin);

        BookCopy bookCopy = new BookCopy(1L, book);
        bookCopyRepository.save(bookCopy);

        Loan loan = loanService.createLoan(audrin.getId(), bookCopy.getId(),LocalDateTime.of(2026, 11,1, 2,1));
        System.out.println(loan.getId());
        loanService.returnLoan(loan.getId());

        System.out.println(bookService.searchBook("ASD"));
        System.out.println(userService.searchUser("Audrin"));



    }
}