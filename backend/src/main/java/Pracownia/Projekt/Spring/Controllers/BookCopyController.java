package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Mapper.BookCopyMapper;
import Pracownia.Projekt.Spring.Model.PageResponse;
import Pracownia.Projekt.Spring.Services.BookCopyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public PageResponse<BookCopyDto> getBookCopies(@RequestParam(required = false) Integer pageNumber,
                                                   @RequestParam(required = false) Integer pageSize) {

        Page<BookCopyDto> bookCopyPage =  bookCopyService.getAll(pageNumber, pageSize);
        return new PageResponse<>(bookCopyPage);
    }

    @PostMapping("/book/{bookId}/bookCopies")
    public BookCopyDto createBookCopy(@PathVariable Integer bookId) {
        return bookCopyService.createBookCopy(bookId);
    }

}
