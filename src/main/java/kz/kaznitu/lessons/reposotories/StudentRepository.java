package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,String> {
    Optional<Student> findByFirstName(String firstName);
}
