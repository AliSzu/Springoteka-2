package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Mapper.BookCopyMapper;
import Pracownia.Projekt.Spring.Model.PageResponse;
import Pracownia.Projekt.Spring.Services.BookCopyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Tag(name = "BookCopy")
@RequestMapping("/api")
public class BookCopyController {

    private final BookCopyService bookCopyService;

    @Autowired
    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @GetMapping("/bookCopies")
    public PageResponse<BookCopyDto> getBookCopies(@RequestParam(required = false) Integer pageNumber,
                                                   @RequestParam(required = false) Integer pageSize) {

        return bookCopyService.getAll(pageNumber, pageSize);
    }

    @GetMapping("/bookCopies/{id}")
    public BookCopyDto getBookCopyById(@PathVariable Integer id) {
        return bookCopyService.getById(id);
    }

    @PostMapping("/bookCopies")
    public BookCopyDto createBookCopy(@RequestBody Integer bookId) {
        return bookCopyService.createBookCopy(bookId);
    }

}
