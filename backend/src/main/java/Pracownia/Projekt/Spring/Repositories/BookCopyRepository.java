package Pracownia.Projekt.Spring.Repositories;

import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Integer> {

}

