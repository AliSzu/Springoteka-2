package Pracownia.Projekt.Spring.DTO;

import Pracownia.Projekt.Spring.Model.AuthorShort;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Pracownia.Projekt.Spring.Entities.Book}
 */
public record BookDto(Long id, String title, AuthorShort author) implements Serializable {
}