package Pracownia.Projekt.Spring.Services;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Mapper.BookCopyMapper;
import Pracownia.Projekt.Spring.Repositories.AuthorRepository;
import Pracownia.Projekt.Spring.Repositories.BookCopyRepository;
import Pracownia.Projekt.Spring.Repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith( {MockitoExtension.class, SpringExtension.class} )
class BookCopyServiceImplTest {
    private Author author;
    private Book book;

    @Mock
    BookCopyRepository bookCopyRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
    BookCopyMapper bookCopyMapper;

    BookCopyServiceImpl bookCopyServiceImpl;

    @BeforeEach
    void setUp() {
        bookCopyServiceImpl = new BookCopyServiceImpl(bookCopyRepository, bookRepository, bookCopyMapper);
        author = new Author(12L, "Adam", "Mickiewicz", null, null);
        book = new Book(11, "Dziady", 123123, author, null, null);
    }

    @Mock
    AuthorRepository authorRepository;

    @Test()
    void whenCreateBookCopyShouldThrowErrorWhenBookNotFound() {
        final Throwable throwable = catchThrowable(() -> bookCopyServiceImpl.createBookCopy(1223));
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
    }
    @Test()
    void shouldThrowErrorWhenBookCopyNotFound() {
        final Throwable throwable = catchThrowable(() -> bookCopyServiceImpl.getById(111));
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
    }


}