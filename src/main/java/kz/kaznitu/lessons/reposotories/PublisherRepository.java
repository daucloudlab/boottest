package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
 }
