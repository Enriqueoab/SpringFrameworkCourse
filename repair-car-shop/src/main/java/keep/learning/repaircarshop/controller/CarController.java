package keep.learning.repaircarshop.controller;

import keep.learning.repaircarshop.repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping("/cars")
    public String getCar(Model model){

        model.addAttribute("cars", carRepository.findAll());

        return "cars/list";
    }

}
