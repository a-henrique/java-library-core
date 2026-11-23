package library.java.service;

import br.com.company.library.domain.Book;
import br.com.company.library.domain.BookCopy;
import br.com.company.library.domain.Loan;
import br.com.company.library.domain.User;
import br.com.company.library.repository.BookCopyRepository;
import br.com.company.library.repository.LoanRepository;
import br.com.company.library.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LoanServiceTest {

    @Test
    void shouldSaveWhenBarrowing(){
        LoanRepository loanRepository = mock(LoanRepository.class);

        UserRepository userRepository = mock(UserRepository.class);

        BookCopyRepository bookCopyRepository = mock(BookCopyRepository.class);

        br.com.company.library.service.LoanService loanService = new br.com.company.library.service.LoanService(userRepository, bookCopyRepository, loanRepository);

        User user = new User(1L, "teste", "teste@gimal.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Book book = new Book(1L, "Y", "123", "EU");

        BookCopy bookCopy = new BookCopy(1L, book);

        when(bookCopyRepository.findById(1L)).thenReturn(Optional.of(bookCopy));

        ArgumentCaptor<Loan> captor = ArgumentCaptor.forClass(Loan.class);



        loanService.createLoan(user.getId(), bookCopy.getId(), LocalDateTime.of(2026, 11,1, 2,1));
        verify(loanRepository).save(captor.capture());
        Loan savedLoan = captor.getValue();

        assertEquals(user.getId(), savedLoan.getUser().getId());
        assertEquals(bookCopy.getId(), savedLoan.getBookCopy().getId());

        verify(loanRepository, times(1)).save(any(Loan.class));

    }
}
