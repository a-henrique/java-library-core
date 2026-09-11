package br.com.company;

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