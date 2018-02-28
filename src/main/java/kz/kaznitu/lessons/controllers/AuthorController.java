package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.reposotories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")

public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("author", new Author());
        return "author_add_form";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/demo/all2";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Author> allAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/all2")
    public String allAuthors2(Model model) {
        List<Author> authors = (List<Author>) authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.GET)
    public ModelAndView deleteAuthor(@RequestParam("id") long idd) {
        authorRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }
    @PostMapping("/editAuthor")
     public String editAuthor(@ModelAttribute Author author) {
        Author author1 = new Author();
        author1.setId(a);
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());
        authorRepository.save(author1);
        return "redirect:/demo/all2";
    }

    @RequestMapping(value = "/editAuthor",method = RequestMethod.GET)
     public ModelAndView editAuthor(Model model,@RequestParam("id") long id){
                a=id;
                Optional<Author> author = (Optional <Author>) authorRepository.findById(id);
                model.addAttribute("author",author);
                return new ModelAndView("smp");
   }
    @RequestMapping("/editAuthor")
     public String showForm2(Model model){
                model.addAttribute("author",new Author());
                return "smp";
            }
}