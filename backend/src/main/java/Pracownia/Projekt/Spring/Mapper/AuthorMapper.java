package Pracownia.Projekt.Spring.Mapper;

import Pracownia.Projekt.Spring.DTO.AuthorDto;
import Pracownia.Projekt.Spring.DTO.PostAuthorDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );

    @Mapping(target = "id", ignore = true) // Ignore id mapping since it's generated
    @Mapping(target = "createdAt", ignore = true) // Ignore createdAt mapping since it's generated
    Author dtoToEntity(PostAuthorDTO dto);

    List<AuthorDto> entityToGetAuthors(List<Author> author);
    @Mapping(target = "numberOfBooks", source = "books", qualifiedByName = "countBooks")
    AuthorDto entityToGetAuthors(Author author);

    @Named("countBooks")
    static int countBooks(Set<Book> books) {
        System.out.println(books);
        return books != null ? books.size() : 0;
    }

}
