package Pracownia.Projekt.Spring.Config.Generator;

import Pracownia.Projekt.Spring.DTO.PostAuthorDTO;
import Pracownia.Projekt.Spring.DTO.PostBookDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Repositories.AuthorRepository;
import Pracownia.Projekt.Spring.Repositories.BookCopyRepository;
import Pracownia.Projekt.Spring.Repositories.BookRepository;
import Pracownia.Projekt.Spring.Services.AuthorService;
import Pracownia.Projekt.Spring.Services.BookCopyService;
import Pracownia.Projekt.Spring.Services.BookService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

// DataGenerator.java
@Component
public class DataGenerator {

    private final AuthorService authorService;
    private final BookService bookService;
    private final BookCopyService bookCopyService;

    private final Faker faker;


    @Autowired
    public DataGenerator(AuthorService authorService, BookService bookService, BookCopyService bookCopyService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookCopyService = bookCopyService;
        this.faker = new Faker();
    }

    public void generateData() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            PostAuthorDTO author = new PostAuthorDTO();
            author.setFirstName(faker.name().firstName());
            author.setLastName(faker.name().lastName());
            Integer authorId = Math.toIntExact(authorService.createAuthor(author).getId());

            int numberOfBooks = rand.nextInt(5);
            for (int j = 0; j < numberOfBooks; j++) {  // Generate 3 books for each author
                PostBookDTO book = new PostBookDTO();
                book.setTitle(faker.book().title());
                Integer bookId = bookService.save(book, authorId).getId();

                int numberOfCopies = rand.nextInt(10);

                for (int k = 0; k < 2; k++) {
                    bookCopyService.createBookCopy(bookId);
                }
            }
        }
    }
}

