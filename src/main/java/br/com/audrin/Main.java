package br.com.audrin;

import br.com.audrin.library.domain.Book;
import br.com.audrin.library.domain.BookCopy;
import br.com.audrin.library.domain.Loan;
import br.com.audrin.library.domain.User;
import br.com.audrin.library.repository.BookCopyRepository;
import br.com.audrin.library.repository.BookRepository;
import br.com.audrin.library.repository.LoanRepository;
import br.com.audrin.library.repository.UserRepository;
import br.com.audrin.library.repository.memory.InMemoryBookCopyRepository;
import br.com.audrin.library.repository.memory.InMemoryBookRepository;
import br.com.audrin.library.repository.memory.InMemoryLoanRepository;
import br.com.audrin.library.repository.memory.InMemoryUserRepository;
import br.com.audrin.library.service.BookService;
import br.com.audrin.library.service.LoanService;
import br.com.audrin.library.service.UserService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        LoanRepository loanRepository = new InMemoryLoanRepository();
        BookCopyRepository bookCopyRepository = new InMemoryBookCopyRepository();
        BookRepository bookRepository = new InMemoryBookRepository();

        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        LoanService loanService = new LoanService(userRepository, bookCopyRepository, loanRepository);
    }
}