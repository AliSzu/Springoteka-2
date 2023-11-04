package Pracownia.Projekt.Spring.Repositories;

import Pracownia.Projekt.Spring.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}

