package kz.kaznitu.lessons.controllers;


import kz.kaznitu.lessons.models.Publisher;
import kz.kaznitu.lessons.reposotories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/pub")
public class PublisherController {
    @Autowired
    private PublisherRepository publisherRepository ;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("publisher",new Publisher());
        return "publisher_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model) {
        model.addAttribute("publisherr", new Publisher());
        return "update";
    }
    @PostMapping("/add")
    public String addPublisher(@ModelAttribute Publisher publisher){
        publisherRepository.save(publisher) ;
        return "redirect:/pub/all" ;
    }

    @GetMapping("/all2")
    public @ResponseBody Iterable<Publisher> allPublisher(){
        return publisherRepository.findAll() ;
    }


    @GetMapping("/all")
    public String allPublisher2(Model model){
        List<Publisher> publishers = (List<Publisher>) publisherRepository.findAll();
        model.addAttribute("publishers", publishers) ;
        return "publishers" ;
    }

    @PostMapping("/adds")
    public String addsPublisher(@ModelAttribute Publisher publisher){
        Publisher publisher1 = new Publisher();
        publisher1.setId(a);
        publisher1.setName(publisher.getName());
        publisher1.setEmail(publisher.getEmail());
        publisher1.setPhone(publisher.getPhone());
        publisher1.setAddress(publisher.getAddress());
        publisherRepository.save(publisher1) ;

        return "redirect:/pub/all" ;
    }

    @RequestMapping(value = "/deletePublisher", method = RequestMethod.GET)
    public ModelAndView deleteContact (@RequestParam("id")long idd){
        publisherRepository.deleteById(idd);
        return new ModelAndView("redirect:/pub/all");
    }
}
