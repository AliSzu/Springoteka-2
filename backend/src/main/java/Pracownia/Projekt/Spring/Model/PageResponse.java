package Pracownia.Projekt.Spring.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Setter
@Getter
public class PageResponse<T> {
    List<T> content;
    CustomPageable pageable;

    public PageResponse(Page<T> page) {
        this.content = page.getContent();
        this.pageable = new CustomPageable(page.getPageable().getPageNumber() + 1,
                page.getPageable().getPageSize(), page.getTotalElements());
    }
}
