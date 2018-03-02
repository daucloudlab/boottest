package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
 Optional<Publisher> findById(Long id);
 }
