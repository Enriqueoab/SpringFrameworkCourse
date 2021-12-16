package keep.learning.carshop.controller;

import keep.learning.carshop.repositories.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController  {

    private OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @RequestMapping("/owners")
    public String getOwners(Model model){

        model.addAttribute("owners", ownerRepository.findAll());

        return "owner/list";
    }
}
