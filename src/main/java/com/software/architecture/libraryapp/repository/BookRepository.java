package com.software.architecture.libraryapp.repository;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.Genres;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaSpecificationExecutor<Book> {
    List<Book> findAll();

    List<Book> findAll(Specification<Book> spec);

    Optional<Book> findById(Integer id);

    List<Book> findByIsAvailable(boolean available);

    static Specification<Book> titleLike(String title) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    static Specification<Book> authorLike(String author) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("author"), "%" + author + "%");
    }

    static Specification<Book> bookGenre(Genres genre) {
        return ((root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("genre"), genre));
    }

    default List<Book> findAllByFilters(String title, String author, String genre) {
        final List<Specification<Book>> specificationList = new ArrayList<>();
        if (title != null) {
            specificationList.add(titleLike(title));
        }
        if (author != null) {
            specificationList.add(authorLike(author));
        }
        if (genre != null) {
            Genres fromString = EnumUtils.findEnumInsensitiveCase(Genres.class, genre);
            specificationList.add(bookGenre(fromString));
        }
        Specification<Book> where = Specification.where(specificationList.get(0));
        for (int i = 1; i < specificationList.size(); i++) {
            where = where.and(specificationList.get(i));
        }
        return this.findAll(where);
    }
}
