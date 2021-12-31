package keep.learning.dependencyinjection.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHellow() {

        System.out.println("Hello world!!");
        return "Hey, How are you doing?";
    }

}
