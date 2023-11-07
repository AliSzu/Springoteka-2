package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import Pracownia.Projekt.Spring.Mapper.BookCopyMapper;
import Pracownia.Projekt.Spring.Repositories.BookCopyRepository;
import Pracownia.Projekt.Spring.Repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;
    private final BookCopyMapper bookCopyMapper;

    public List<BookCopy> getAll() {return bookCopyRepository.findAll();}

    public BookCopyDto createBookCopy(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Book with ID " + bookId + " not found"));

        BookCopy newCopy = bookCopyMapper.bookToBookCopy(book);
        BookCopy bookCopy = bookCopyRepository.save(newCopy);

        return bookCopyMapper.bookCopyToDto(bookCopy);


    }
}
