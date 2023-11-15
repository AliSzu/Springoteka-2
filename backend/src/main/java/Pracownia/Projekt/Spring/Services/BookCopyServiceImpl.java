package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import Pracownia.Projekt.Spring.Mapper.BookCopyMapper;
import Pracownia.Projekt.Spring.Model.PageResponse;
import Pracownia.Projekt.Spring.Repositories.BookCopyRepository;
import Pracownia.Projekt.Spring.Repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static Pracownia.Projekt.Spring.Utils.PageBuilder.buildPageRequest;

@Service
public class BookCopyServiceImpl implements BookCopyService{
    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;
    private final BookCopyMapper bookCopyMapper;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository, BookRepository bookRepository, BookCopyMapper bookCopyMapper) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookRepository = bookRepository;
        this.bookCopyMapper = bookCopyMapper;
    }

    @Override
    public PageResponse<BookCopyDto> getAll(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);

        Page<BookCopy> bookCopyPage = bookCopyRepository.findAll(pageRequest);
        Page<BookCopyDto> bookCopyDtoPage = bookCopyPage.map(bookCopyMapper::bookCopyToDto);
        return new PageResponse<>(bookCopyDtoPage);
    }

    @Override
    public BookCopyDto getById(Integer id) {
        BookCopy bookCopy = bookCopyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book Copy with ID " + id + " not found"));
        return bookCopyMapper.bookCopyToDto(bookCopy);
    }

    @Override
    public BookCopyDto createBookCopy(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Book with ID " + bookId + " not found"));

        BookCopy newCopy = bookCopyMapper.bookToBookCopy(book);
        BookCopy bookCopy = bookCopyRepository.save(newCopy);

        return bookCopyMapper.bookCopyToDto(bookCopy);
    }

    @Override
    public void deleteBookCopy(Integer id) {
        if(!bookCopyRepository.existsById(id)) {
            throw new EntityNotFoundException("Book Copy with ID " + id + " not found");
        }
        bookCopyRepository.deleteById(id);
    }

    @Override
    public void deleteBookCopyInBulk(List<Long> ids) {
        for (Long id : ids) {
            if(!bookCopyRepository.existsById(Math.toIntExact(id))) {
                throw new EntityNotFoundException("Book Copy with ID" + id + " not found");
            }
        }
        bookCopyRepository.deleteBookCopyInBulk(ids);
    }
}
