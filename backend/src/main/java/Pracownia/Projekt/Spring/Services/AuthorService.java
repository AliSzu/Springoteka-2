package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.DTO.AuthorDto;
import Pracownia.Projekt.Spring.DTO.PostAuthorDTO;
import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Mapper.AuthorMapper;
import Pracownia.Projekt.Spring.Repositories.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<Author> listAllAuthors() {return authorRepository.findAll();}

    public Author getAuthorById(Integer id) {
        if(!authorRepository.existsById(id)) {
            throw new EntityNotFoundException("Author with ID " + id + " not found");
        }
        return authorRepository.getReferenceById(id);
    }

    public Author createAuthor(PostAuthorDTO author) {
        Author mappedAuthor = AuthorMapper.INSTANCE.dtoToEntity(author);
        return authorRepository.save(mappedAuthor);
    }
}
