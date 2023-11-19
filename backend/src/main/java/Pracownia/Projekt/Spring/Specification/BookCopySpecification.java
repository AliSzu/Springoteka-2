package Pracownia.Projekt.Spring.Specification;

import Pracownia.Projekt.Spring.Entities.BookCopy;
import Pracownia.Projekt.Spring.Model.SearchCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BookCopySpecification implements Specification<BookCopy> {

    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<BookCopy> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        criteria.setKey("author.title");

        if (root.get(criteria.getKey()).getJavaType() == String.class) {
            return builder.like(
                    root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
    }
}
