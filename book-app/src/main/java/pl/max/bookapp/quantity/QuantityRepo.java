package pl.max.bookapp.quantity;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.max.bookapp.quantity.Quantity;

@Repository
public interface QuantityRepo extends CrudRepository<Quantity, Long> {
}
