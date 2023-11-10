package Pracownia.Projekt.Spring.Services.Utils;

import Pracownia.Projekt.Spring.DTO.BookCopyDto;
import Pracownia.Projekt.Spring.Entities.BookCopy;
import Pracownia.Projekt.Spring.Model.AuthorShort;
import Pracownia.Projekt.Spring.Utils.Constants.Status;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<BookCopyDto> getDummyBookCopiesDto(final int n) {
        final List<BookCopyDto> bookCopiesDto = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            bookCopiesDto.add(
                    new BookCopyDto(2L, null, Status.AVAILABLE, "Dziady", 1231, new AuthorShort(1L, "Adam", "Mickiewicz"))
            );
        }

        return bookCopiesDto;
    }

    public static List<BookCopy> getDummyBookCopies(final int n) {
        final List<BookCopy> bookCopiesDto = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            bookCopiesDto.add(
                    new BookCopy(2L, null, Status.AVAILABLE, null)
            );
        }

        return bookCopiesDto;
    }
}
