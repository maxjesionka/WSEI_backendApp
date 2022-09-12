package pl.max.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.max.bookapp.manager.BookManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookApi {

  private BookManager books;

  @Autowired
    public BookApi(BookManager books) {
        this.books = books;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return books.findALL();
    }
    @GetMapping
    public Optional<Book> getById(@RequestParam Long index) {

        return books.findById(index);
    }
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return books.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return books.save(book);
    }
    @DeleteMapping
    public void deleteBook(@RequestParam Long index) {
        books.deleteById(index);
    }
}
