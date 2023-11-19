package Pracownia.Projekt.Spring.Utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static Pracownia.Projekt.Spring.Utils.Constants.Constants.DEFAULT_PAGE;
import static Pracownia.Projekt.Spring.Utils.Constants.Constants.DEFAULT_PAGE_SIZE;

public class PageBuilder {
    public static PageRequest buildPageRequest(Integer pageNumber, Integer pageSize, String sortBy, String orderBy) {
        int queryPageNumber;
        int queryPageSize;
        Sort sort = Sort.by(sortBy);

        if(pageNumber != null && pageNumber > 0) {
            queryPageNumber = pageNumber - 1;
        } else {
            queryPageNumber = DEFAULT_PAGE;
        }

        if (pageSize == null) {
            queryPageSize = DEFAULT_PAGE_SIZE;
        } else {
            if(pageSize > 1000) {
                queryPageSize = 1000;
            }
            queryPageSize = pageSize;
        }

        return PageRequest.of(queryPageNumber, queryPageSize, orderBy.equals("desc") ? sort.descending() : sort.ascending());
    }
}
