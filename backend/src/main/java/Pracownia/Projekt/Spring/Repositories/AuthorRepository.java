package Pracownia.Projekt.Spring.Repositories;

import Pracownia.Projekt.Spring.Entities.Author;
import Pracownia.Projekt.Spring.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}

