package Pracownia.Projekt.Spring.Mapper;

import Pracownia.Projekt.Spring.DTO.BookDto;
import Pracownia.Projekt.Spring.DTO.PostBookDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    @Mapping(target = "id", ignore = true) // Ignore id mapping since it's generated
    @Mapping(target = "createdAt", ignore = true) // Ignore createdAt mapping since it's generated
    @Mapping(target = "author", source = "author") // Map author from Author entity
    Book PostBookDtoToEntity(PostBookDTO dto, Author author);

    @Mapping(source = "author.id", target = "author.id")
    @Mapping(source ="author.firstName", target ="author.firstName")
    @Mapping(source = "author.lastName", target = "author.lastName")
    BookDto EntityToDto(Book book);
}