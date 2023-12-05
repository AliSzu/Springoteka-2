package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Model.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookCopyService {

    PageResponse<BookCopyDto> getAll(Integer pageNumber, Integer pageSize, String sortBy, String orderBy);
    BookCopyDto getById(Integer id);
    BookCopyDto createBookCopy(Integer bookId);
    void deleteBookCopy(Integer id);
    void deleteBookCopyInBulk(List<Long> ids);

}
