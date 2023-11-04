package Pracownia.Projekt.Spring.Mapper;

import Pracownia.Projekt.Spring.DTO.BookDto;
import Pracownia.Projekt.Spring.DTO.PostBookDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Model.AuthorShort;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-03T15:55:17+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book PostBookDtoToEntity(PostBookDTO dto, Author author) {
        if ( dto == null && author == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        if ( dto != null ) {
            book.title( dto.getTitle() );
        }
        book.author( author );

        return book.build();
    }

    @Override
    public BookDto EntityToDto(Book book) {
        if ( book == null ) {
            return null;
        }

        AuthorShort author = null;
        Long id = null;
        String title = null;

        author = authorToAuthorShort( book.getAuthor() );
        id = book.getId();
        title = book.getTitle();

        BookDto bookDto = new BookDto( id, title, author );

        return bookDto;
    }

    protected AuthorShort authorToAuthorShort(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorShort authorShort = new AuthorShort();

        authorShort.setId( author.getId() );
        authorShort.setFirstName( author.getFirstName() );
        authorShort.setLastName( author.getLastName() );

        return authorShort;
    }
}
