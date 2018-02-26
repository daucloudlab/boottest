package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findById(Long id);
}
