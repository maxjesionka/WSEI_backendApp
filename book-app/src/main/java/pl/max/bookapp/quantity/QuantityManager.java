package pl.max.bookapp.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.max.bookapp.quantity.Quantity;
import pl.max.bookapp.quantity.QuantityRepo;


import java.util.Optional;

@Service
public class QuantityManager {

    private QuantityRepo quantityRepo;

    @Autowired
    public QuantityManager(QuantityRepo quantityRepo) {
        this.quantityRepo = quantityRepo;
    }

    public Optional<Quantity> findById(Long id) {
        return quantityRepo.findById(id);
    }

    public Iterable<Quantity> findALL() {
        return quantityRepo.findAll();
    }

    public Quantity save(Quantity quantity) {
        return quantityRepo.save(quantity);
    }

    public void deleteById(Long id) {
        quantityRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Quantity(1L,96L));
        save(new Quantity(2L,16L));

    }
}
