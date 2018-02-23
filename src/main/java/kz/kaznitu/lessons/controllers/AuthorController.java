package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.reposotories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository ;

    @RequestMapping("/show")
    public String showForm(Model model){
        model.addAttribute("author",new Author());
        return "inp";
    }

    @GetMapping("/add")
    public @ResponseBody String addAuthor(@RequestParam("firstname") String firstName,
                                          @RequestParam("lastname") String lastName,
                                          @RequestParam("email") String email){
        Author author = new Author(firstName, lastName, email) ;
        authorRepository.save(author);
        return "saved" ;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Author> allAuthors(){
        return authorRepository.findAll() ;
    }

    @GetMapping("/all2")
    public String allAuthors2(Model model){
        List<Author> authors = (List<Author>) authorRepository.findAll();
        model.addAttribute("authors", authors) ;
        return "authors" ;
    }


    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        authorRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }
}
