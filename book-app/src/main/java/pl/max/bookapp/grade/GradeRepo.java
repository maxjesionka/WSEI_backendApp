package pl.max.bookapp.grade;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.max.bookapp.grade.Grade;

@Repository
public interface GradeRepo extends CrudRepository<Grade, Long> {
}
