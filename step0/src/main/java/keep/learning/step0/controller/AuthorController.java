package keep.learning.step0.controller;

import keep.learning.step0.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //It tells the Spring framework, this class is to be added into the Spring context as controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model) {

        model.addAttribute("authors", authorRepository.findAll());//"authors" is a variable to call it in out template

        return "authors/list";
    }
}
