package pl.max.bookapp.borrowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.max.bookapp.borrowed.Borrowed;
import pl.max.bookapp.borrowed.BorrowedRepo;


import java.util.Optional;

@Service
public class BorrowedManager {

    private BorrowedRepo borrowedRepo;

    @Autowired
    public BorrowedManager(BorrowedRepo borrowedRepo) {
        this.borrowedRepo = borrowedRepo;
    }

    public Optional<Borrowed> findById(Long id) {
        return borrowedRepo.findById(id);
    }

    public Iterable<Borrowed> findALL() {
        return borrowedRepo.findAll();
    }

    public Borrowed save(Borrowed borrowed) {
        return borrowedRepo.save(borrowed);
    }

    public void deleteById(Long id) {
        borrowedRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Borrowed(1L,9L));
        save(new Borrowed(2L,6L));

    }
}
