package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.DTO.BookDto;
import Pracownia.Projekt.Spring.DTO.PatchBookDTO;
import Pracownia.Projekt.Spring.DTO.PostBookDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Mapper.BookMapper;
import Pracownia.Projekt.Spring.Repositories.AuthorRepository;
import Pracownia.Projekt.Spring.Repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.beans.FeatureDescriptor;

import java.util.*;
import java.util.stream.Stream;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookMapper bookMapper;

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book save(PostBookDTO bookDTO, Integer authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author with ID " + authorId + " not found"));
        Book book = bookMapper.PostBookDtoToEntity(bookDTO, author);
        return bookRepository.save(book);
    };
    public boolean existsById(Integer id) {
        return bookRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(Integer id) {return bookRepository.findById(id);}

    public Book patchBook(PatchBookDTO newBook, Integer id) {

        final BeanWrapper wrappedSource = new BeanWrapperImpl(newBook);
        String[] nulls = Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);

        Book bookToUpdate = bookRepository.getReferenceById(id);
        BeanUtils.copyProperties(newBook, bookToUpdate, nulls);

        return bookRepository.save(bookToUpdate);
    }

}
