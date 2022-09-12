package pl.max.bookapp.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.max.bookapp.quantity.QuantityManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/quantity")
public class QuantityApi {

    private QuantityManager quantities;

    @Autowired
    public QuantityApi(QuantityManager quantities) {
        this.quantities = quantities;
    }

    @GetMapping("/all")
    public Iterable<Quantity> getAll() {
        return quantities.findALL();
    }
    @GetMapping
    public Optional<Quantity> getById(@RequestParam Long index) {

        return quantities.findById(index);
    }
    @PostMapping
    public Quantity addQuantity(@RequestBody Quantity quantity) {
        return quantities.save(quantity);
    }

    @PutMapping
    public Quantity updateQuantity(@RequestBody Quantity quantity) {
        return quantities.save(quantity);
    }
    @DeleteMapping
    public void deleteQuantity(@RequestParam Long index) {
        quantities.deleteById(index);
    }
}
