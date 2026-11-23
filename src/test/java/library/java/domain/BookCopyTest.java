package library.java.domain;

import br.com.company.library.domain.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock.*;

public class BookCopyTest {
    @Test
    void shouldChangeStatusToBorrowedWhenBorrowing(){

        Book book = new Book(1L, "Y Book", "123","Eu");
        BookCopy bookCopy = new BookCopy(1L, book);

        bookCopy.borrow();

        assertEquals(BookCopyStatus.BORROWED, bookCopy.getStatus());

    }

    @Test
    void shouldNotBorrowAlreadyBorrowedCopy(){
        Book book = new Book(1L,"Y BOOK", "123", "Eu");
        BookCopy bookCopy = new BookCopy(1L, book);

        bookCopy.borrow();

        assertThrows(IllegalStateException.class, () -> bookCopy.borrow());
    }
}
