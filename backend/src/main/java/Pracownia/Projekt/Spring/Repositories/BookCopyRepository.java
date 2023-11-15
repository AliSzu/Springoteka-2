package Pracownia.Projekt.Spring.Repositories;

import Pracownia.Projekt.Spring.Entities.Book;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Integer> {

    Page<BookCopy> findAll(Pageable pageable);

    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Transactional
    @Query("delete from BookCopy where id in (:ids)")
    void deleteBookCopyInBulk(List<Long> ids);


}

