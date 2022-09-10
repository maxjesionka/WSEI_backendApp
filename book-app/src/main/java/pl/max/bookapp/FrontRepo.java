package pl.max.bookapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FrontRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    public List<Book> getAll(){
//        return jdbcTemplate.query("SELECT id, title, productionYear FROM ");
//    }
}
