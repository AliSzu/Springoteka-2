package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Model.PageResponse;
import Pracownia.Projekt.Spring.Services.BookCopyService;
import Pracownia.Projekt.Spring.Validator.CustomAnnotation.ValuesAllowed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@Tag(name = "BookCopy")
@RequestMapping("/api")
public class BookCopyController {

    private final BookCopyService bookCopyService;

    @Autowired
    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @Operation(summary = "Get book copies in paginated list")
    @GetMapping("/bookCopies")
    public PageResponse<BookCopyDto> getBookCopies(@Parameter(description = "The initial page from which to return the results.") @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                   @Parameter(description = "Number of results to return per page.") @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                                   @Parameter(description = "Field by which the data should be sorted. The default option - createdAt. The all possible options createdAt, title, status and author")
                                                   @RequestParam(required = false, defaultValue = "createdAt") @ValuesAllowed(values = {"createdAt", "title", "status", "author"}) String sortBy) {

        return bookCopyService.getAll(pageNumber, pageSize, sortBy);
    }

    @Operation(summary = "Get Book Copy by id")
    @GetMapping("/bookCopies/{id}")
    public BookCopyDto getBookCopyById(@Parameter(description = "id of book copy to be searched") @PathVariable Integer id) {
        return bookCopyService.getById(id);
    }

    @Operation(summary = "Create new Book Copy")
    @PostMapping("/bookCopies")
    public BookCopyDto createBookCopy(@Parameter(description = "id of book to made copy of") @RequestParam Integer id) {
        return bookCopyService.createBookCopy(id);
    }

    //    @Operation(summary= "Delete book copies")
    @DeleteMapping("/bookCopies/{id}")
    public void deleteBookCopy(@PathVariable Integer id) {
        bookCopyService.deleteBookCopy(id);
    }

    @DeleteMapping("/bookCopies")
    public void deleteBookCopyInBulks(@RequestParam List<Long> ids) {
        bookCopyService.deleteBookCopyInBulk(ids);
    }

}
