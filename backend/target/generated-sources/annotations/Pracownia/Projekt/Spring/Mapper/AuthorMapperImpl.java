package Pracownia.Projekt.Spring.Mapper;

import Pracownia.Projekt.Spring.DTO.AuthorDto;
import Pracownia.Projekt.Spring.DTO.PostAuthorDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-03T16:41:10+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author dtoToEntity(PostAuthorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstName( dto.getFirstName() );
        author.setLastName( dto.getLastName() );

        return author;
    }

    @Override
    public List<AuthorDto> entityToGetAuthors(List<Author> author) {
        if ( author == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( author.size() );
        for ( Author author1 : author ) {
            list.add( entityToGetAuthors( author1 ) );
        }

        return list;
    }

    @Override
    public AuthorDto entityToGetAuthors(Author author) {
        if ( author == null ) {
            return null;
        }

        Long numberOfBooks = null;
        Long id = null;
        String firstName = null;
        String lastName = null;
        Date createdAt = null;

        if ( author.getBooks() != null ) {
            numberOfBooks = (long) AuthorMapper.countBooks( author.getBooks() );
        }
        id = author.getId();
        firstName = author.getFirstName();
        lastName = author.getLastName();
        createdAt = author.getCreatedAt();

        AuthorDto authorDto = new AuthorDto( id, firstName, lastName, createdAt, numberOfBooks );

        return authorDto;
    }
}
