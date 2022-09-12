package pl.max.bookapp.borrowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.max.bookapp.borrowed.BorrowedManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/borrowed")
public class BorrowedApi {

    private BorrowedManager borrowedAll;

    @Autowired
    public BorrowedApi(BorrowedManager borrowedAll) {
        this.borrowedAll = borrowedAll;
    }

    @GetMapping("/all")
    public Iterable<Borrowed> getAll() {
        return borrowedAll.findALL();
    }
    @GetMapping
    public Optional<Borrowed> getById(@RequestParam Long index) {

        return borrowedAll.findById(index);
    }
    @PostMapping
    public Borrowed addBorrowed(@RequestBody Borrowed borrowed) {
        return borrowedAll.save(borrowed);
    }

    @PutMapping
    public Borrowed updateBorrowed(@RequestBody Borrowed borrowed) {
        return borrowedAll.save(borrowed);
    }
    @DeleteMapping
    public void deleteBorrowed(@RequestParam Long index) {
        borrowedAll.deleteById(index);
    }
}
