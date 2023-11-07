package Pracownia.Projekt.Spring.Mapper;

import Pracownia.Projekt.Spring.Constants.Status;
import Pracownia.Projekt.Spring.DTO.AuthorDto;
import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface BookCopyMapper {

    BookCopyMapper INSTANCE = Mappers.getMapper(BookCopyMapper.class);

    @Mapping(target="book", source="book")
    @Mapping(target = "id", ignore = true) // Ignore id mapping since it's generated
    @Mapping(target="status", constant = "AVAILABLE")
    BookCopy bookToBookCopy(Book book);

    List<BookCopyDto> bookCopyToDto(List<BookCopy> bookCopy);

    @Mapping(target="title", source="bookCopy.book.title")
    @Mapping(target="authorShort.id", source="bookCopy.book.author.id")
    @Mapping(target="authorShort.firstName", source="bookCopy.book.author.firstName")
    @Mapping(target="authorShort.lastName", source="bookCopy.book.author.lastName")
    @Mapping(target="ISBN", source="bookCopy.book.ISBN")
    BookCopyDto bookCopyToDto(BookCopy bookCopy);

}