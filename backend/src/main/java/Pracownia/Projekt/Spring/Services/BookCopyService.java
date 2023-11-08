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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;
    private final BookCopyMapper bookCopyMapper;

    private final static int DEFAULT_PAGE = 0;
    private final static int DEFAULT_PAGE_SIZE = 25;

    public Page<BookCopyDto> getAll(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);

        Page<BookCopy> bookCopyPage = bookCopyRepository.findAll(pageRequest);
        return bookCopyPage.map(bookCopyMapper::bookCopyToDto);
    }

    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize) {
        int queryPageNumber;
        int queryPageSize;

        if(pageNumber != null && pageNumber > 0) {
            queryPageNumber = pageNumber - 1;
        } else {
            queryPageNumber = DEFAULT_PAGE;
        }

        if (pageSize == null) {
            queryPageSize = DEFAULT_PAGE_SIZE;
        } else {
            if(pageSize > 1000) {
                queryPageSize = 1000;
                //TODO: zrobic enuma z pageSize zeby przyjmowało tylko 10, 25 oraz 50
            }
            queryPageSize = pageSize;
        }

        return PageRequest.of(queryPageNumber, queryPageSize);
    }

    public BookCopyDto createBookCopy(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Book with ID " + bookId + " not found"));

        BookCopy newCopy = bookCopyMapper.bookToBookCopy(book);
        BookCopy bookCopy = bookCopyRepository.save(newCopy);

        return bookCopyMapper.bookCopyToDto(bookCopy);


    }
}
