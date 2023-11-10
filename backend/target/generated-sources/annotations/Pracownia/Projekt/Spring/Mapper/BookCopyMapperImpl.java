package Pracownia.Projekt.Spring.Mapper;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import Pracownia.Projekt.Spring.Model.AuthorShort;
import Pracownia.Projekt.Spring.Utils.Constants.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T16:25:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BookCopyMapperImpl implements BookCopyMapper {

    @Override
    public BookCopy bookToBookCopy(Book book) {
        if ( book == null ) {
            return null;
        }

        BookCopy bookCopy = new BookCopy();

        bookCopy.setBook( book );
        bookCopy.setCreatedAt( book.getCreatedAt() );

        bookCopy.setStatus( Status.AVAILABLE );

        return bookCopy;
    }

    @Override
    public List<BookCopyDto> bookCopyToDto(List<BookCopy> bookCopy) {
        if ( bookCopy == null ) {
            return null;
        }

        List<BookCopyDto> list = new ArrayList<BookCopyDto>( bookCopy.size() );
        for ( BookCopy bookCopy1 : bookCopy ) {
            list.add( bookCopyToDto( bookCopy1 ) );
        }

        return list;
    }

    @Override
    public BookCopyDto bookCopyToDto(BookCopy bookCopy) {
        if ( bookCopy == null ) {
            return null;
        }

        AuthorShort author = null;
        String title = null;
        Integer iSBN = null;
        Long id = null;
        Date createdAt = null;
        Status status = null;

        author = bookToAuthorShort( bookCopy.getBook() );
        title = bookCopyBookTitle( bookCopy );
        iSBN = bookCopyBookISBN( bookCopy );
        id = bookCopy.getId();
        createdAt = bookCopy.getCreatedAt();
        status = bookCopy.getStatus();

        BookCopyDto bookCopyDto = new BookCopyDto( id, createdAt, status, title, iSBN, author );

        return bookCopyDto;
    }

    private Long bookAuthorId(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        Long id = author.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookAuthorFirstName(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        String firstName = author.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String bookAuthorLastName(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        String lastName = author.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    protected AuthorShort bookToAuthorShort(Book book) {
        if ( book == null ) {
            return null;
        }

        AuthorShort authorShort = new AuthorShort();

        authorShort.setId( bookAuthorId( book ) );
        authorShort.setFirstName( bookAuthorFirstName( book ) );
        authorShort.setLastName( bookAuthorLastName( book ) );

        return authorShort;
    }

    private String bookCopyBookTitle(BookCopy bookCopy) {
        if ( bookCopy == null ) {
            return null;
        }
        Book book = bookCopy.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Integer bookCopyBookISBN(BookCopy bookCopy) {
        if ( bookCopy == null ) {
            return null;
        }
        Book book = bookCopy.getBook();
        if ( book == null ) {
            return null;
        }
        Integer iSBN = book.getISBN();
        if ( iSBN == null ) {
            return null;
        }
        return iSBN;
    }
}
