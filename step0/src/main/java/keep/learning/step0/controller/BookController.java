package keep.learning.step0.controller;

import keep.learning.step0.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Parameter to set it as MVC controller
public class BookController {

    private final BookRepository bookRepository;

    @RequestMapping("/books") //Create the relation between the "/books" request and the method

    public String getBooks(Model model){ //"model" is what is going to get returned to the view

       model.addAttribute("books", bookRepository.findAll()); //We enhance the model with a list of books

        return "books/list"; //Path to our template
    }

    public BookController(BookRepository bookRepository) {
        //We will get an instance of that book repository through injection
        this.bookRepository = bookRepository;
    }
}
