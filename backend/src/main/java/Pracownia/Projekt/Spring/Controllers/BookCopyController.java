package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import Pracownia.Projekt.Spring.Mapper.BookCopyMapper;
import Pracownia.Projekt.Spring.Mapper.BookMapper;
import Pracownia.Projekt.Spring.Services.BookCopyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "BookCopy")
@RequestMapping("/api")
public class BookCopyController {

    private final BookCopyService bookCopyService;
    private final BookCopyMapper bookCopyMapper;

    @Autowired
    public BookCopyController(BookCopyService bookCopyService, BookCopyMapper bookCopyMapper
    ) {
        this.bookCopyService = bookCopyService;
        this.bookCopyMapper = bookCopyMapper;
    }

    @GetMapping("/bookCopies")
    public List<BookCopyDto> getBookCopies() {

        List<BookCopy> bookCopyList = bookCopyService.getAll();
        return bookCopyMapper.bookCopyToDto(bookCopyList);
    }

    @PostMapping("/book/{bookId}/bookCopies")
    public BookCopyDto createBookCopy(@PathVariable Integer bookId) {
        return bookCopyService.createBookCopy(bookId);
    }

}
