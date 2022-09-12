package pl.max.bookapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.max.bookapp.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
}
