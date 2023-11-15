package Pracownia.Projekt.Spring.DTO;

import Pracownia.Projekt.Spring.Utils.Constants.Status;
import Pracownia.Projekt.Spring.Model.AuthorShort;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Pracownia.Projekt.Spring.Entities.BookCopy}
 */
@Value
public class BookCopyDto implements Serializable {
    Long id;
    Date createdAt;
    Status status;
    String title;
    Integer ISBN;
    AuthorShort author;
}