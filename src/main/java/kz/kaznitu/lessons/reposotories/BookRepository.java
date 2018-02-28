package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {
    Optional<Book> findById(Long id);
    }