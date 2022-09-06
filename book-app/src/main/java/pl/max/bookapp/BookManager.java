package pl.max.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookManager {

    private BookRepo bookRepo;

@Autowired
    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public Optional<Book> findById(Long id) {
        return bookRepo.findById(id);
    }

    public Iterable<Book> findALL() {
        return bookRepo.findAll();
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
    save(new Book(1L,"Ja inkwizytor", LocalDate.of(2005,12,3)));
    save(new Book(2L,"Ja inkwizytor - młot na czarownice",LocalDate.of(2009,2,21)));

    }
}
