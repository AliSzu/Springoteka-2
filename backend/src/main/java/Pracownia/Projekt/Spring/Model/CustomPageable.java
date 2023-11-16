package Pracownia.Projekt.Spring.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Data
@Setter
@Getter
public class CustomPageable {
    int pageNumber;
    int pageSize;
    long totalElements;
    Sort sort;

    public CustomPageable(int pageNumber, int pageSize, long totalElements, Sort sort) {

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.sort = sort;
    }

    public CustomPageable() {

    }
}
