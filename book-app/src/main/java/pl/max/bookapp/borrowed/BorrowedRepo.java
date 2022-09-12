package pl.max.bookapp.borrowed;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.max.bookapp.borrowed.Borrowed;

@Repository
public interface BorrowedRepo extends CrudRepository<Borrowed, Long> {
}
