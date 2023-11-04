package Pracownia.Projekt.Spring.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Pracownia.Projekt.Spring.Entities.Author}
 */
public record AuthorDto(Long id, String firstName, String lastName, Date createdAt, Long numberOfBooks) implements Serializable {
}