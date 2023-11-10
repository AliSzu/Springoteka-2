package Pracownia.Projekt.Spring.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CustomPageable {
    int pageNumber;
    int pageSize;
    long totalElements;

    public CustomPageable(int pageNumber, int pageSize, long totalElements) {

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }
}
