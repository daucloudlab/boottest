package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.reposotories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/demo")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository ;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("author",new Author());
        return "author_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("authorr",new Author());
        return "update";
    }
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author){
        authorRepository.save(author) ;

        return "redirect:/demo/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<Author> allAuthors(){
        return authorRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Author> authors = (List<Author>) authorRepository.findAll();
        model.addAttribute("authors", authors) ;
        return "authors" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Author author){
        Author author1 = new Author();
        author1.setId(a);
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());
        authorRepository.save(author1) ;

        return "redirect:/demo/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Author> author = (Optional <Author> ) authorRepository.findById(id);
        model.addAttribute("authorr",author);
        return new ModelAndView("update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        authorRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all");
    }
}
