package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.models.Book;
import kz.kaznitu.lessons.reposotories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/main")
    public String allBook(Model model){
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books",books);
        return "books";
    }
    @GetMapping("/add")
    public String bookForm(Model model){
        model.addAttribute("book",new Book());
        return "book_add_form";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/book/main";
    }
    @RequestMapping(value = "/deleteBook",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        bookRepository.deleteById(idd);
        return new ModelAndView("redirect:/book/main");
    }

}
