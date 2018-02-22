package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
