package Pracownia.Projekt.Spring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorShort {

    private Long id;
    private String firstName;
    private String lastName;
}
