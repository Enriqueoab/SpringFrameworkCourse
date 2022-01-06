package keep.learning.stoicismquotes.controller;

import keep.learning.stoicismquotes.services.StoicQuotesServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class QuotesController {

    public StoicQuotesServiceImpl stoicQuotesService;

    public QuotesController(StoicQuotesServiceImpl stoicQuotesService) {
        this.stoicQuotesService = stoicQuotesService;
    }

    @RequestMapping("/")
    public String showQuote(Model model){

        model.addAttribute("quote", stoicQuotesService.getQuote());

        return "index";
    }

}
