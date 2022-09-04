package pl.max.bookapp;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/books")
public class BookApi {

    private List<Book> Books;

    public BookApi() {
        Books = new ArrayList<>();
        Books.add(new Book(1L,"Ja inkwizytor",LocalDate.of(2005,12,3)));
        Books.add(new Book(2L,"Ja inkwizytor - młot na czarownice",LocalDate.of(2009,2,21)));
    }
    @GetMapping("/all")
    public List<Book> getAll() {
        return Books;
    }
    @GetMapping
    public Book getById(@RequestParam int index) {
        Optional<Book> first = Books.stream().filter(element -> element.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addBook(@RequestBody Book book) {
        return Books.add(book);
    }

    @PutMapping
    public boolean updateBook(@RequestBody Book book) {
        return Books.add(book);
    }
    @DeleteMapping
    public boolean deleteBook(@RequestParam int index) {
        return Books.removeIf(element -> element.getId() == index);
    }
}
