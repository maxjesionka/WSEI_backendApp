package pl.max.bookapp.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.max.bookapp.Book;
import pl.max.bookapp.repository.BookRepo;

@Controller
public class frontController {

    @Autowired
    BookRepo bookRepo;


//@RequestMapping("/example")
//public String index() {
//    return "xd.html";
//}


    @GetMapping("/booksShow")
    public ModelAndView dataShow(){
//        bookRepo.save(book);
        ModelAndView mv = new ModelAndView("Book");
        mv.addObject("booksConnection", bookRepo.findAll());
        mv.setViewName("books");

        return mv;
    }

    @RequestMapping("/dodawanie")
    public String dataAdding(Book book){
        bookRepo.save(book);
        return "succes";
    }
}