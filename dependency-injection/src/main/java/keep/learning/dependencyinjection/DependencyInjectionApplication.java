package keep.learning.dependencyinjection;

import keep.learning.dependencyinjection.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(DependencyInjectionApplication.class, args);
        //The spring framework is managing the construction of myController
        //We don't have to create a new object
        MyController controller = (MyController) ac.getBean("myController");

        String hi = controller.sayHellow();
        System.out.println(hi);
    }


}
