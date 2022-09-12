package pl.max.bookapp.borrowed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Borrowed {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long borrowed;



    public Borrowed() {
    }

    public Borrowed(Long id, Long borrowed){
        this.id = id;
        this.borrowed = borrowed;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Long borrowed) {
        this.borrowed = borrowed;
    }


}
