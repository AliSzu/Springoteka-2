package Pracownia.Projekt.Spring.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBookDTO {
    @Size(min = 2, message = "title name should have at least 2 characters")
    @NotBlank
    private String title;
}
