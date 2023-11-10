package Pracownia.Projekt.Spring.Services;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Model.PageResponse;
import org.springframework.data.domain.Page;

public interface BookCopyService {

    PageResponse<BookCopyDto> getAll(Integer pageNumber, Integer pageSize);
    BookCopyDto getById(Integer id);
    BookCopyDto createBookCopy(Integer bookId);

}
