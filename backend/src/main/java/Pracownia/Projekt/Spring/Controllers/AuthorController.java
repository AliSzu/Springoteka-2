package Pracownia.Projekt.Spring.Controllers;

import Pracownia.Projekt.Spring.DTO.AuthorDto;
import Pracownia.Projekt.Spring.DTO.PostAuthorDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Mapper.AuthorMapper;
import Pracownia.Projekt.Spring.Services.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Author")
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors() {

        List<Author> authors = authorService.listAllAuthors();
        return authorMapper.entityToGetAuthors(authors);
    }

    @PostMapping
    public Author createAuthor(@RequestBody @Valid @NonNull PostAuthorDTO authorDTO) {
        Author author = AuthorMapper.INSTANCE.dtoToEntity(authorDTO);
        return authorService.createAuthor(author);
    }
}
