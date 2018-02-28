package kz.kaznitu.lessons.controllers;


import kz.kaznitu.lessons.models.Book;
import kz.kaznitu.lessons.reposotories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    private long a;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Book> allBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/all2")
    public String allBooks2(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }
    @RequestMapping("/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book_add_form";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/book/all2";
    }

    @RequestMapping(value = "/deleteBook",method = RequestMethod.GET)
    public ModelAndView deleteBook(@RequestParam("id") long idd){
        bookRepository.deleteById(idd);
        return new ModelAndView("redirect:/book/all2");
    }
    @PostMapping("/editBook")
    public String editBook(@ModelAttribute Book book) {
        Book book1 = new Book();
        book1.setBook_id(a);
        book1.setBook_name(book.getBook_name());
        book1.setBook_author(book.getBook_author());
        book1.setBook_genre(book.getBook_genre());
        book1.setYears(book.getYears());
        bookRepository.save(book1);
        return "redirect:/book/all2";
    }
    @RequestMapping(value = "/editBook",method = RequestMethod.GET)
    public ModelAndView editBook(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Book> book = (Optional<Book>) bookRepository.findById(id);
        model.addAttribute("book",book);
        return new ModelAndView("inp");
    }
    @RequestMapping("/editBook")
    public String bookForm2(Model model){
        model.addAttribute("book",new Book());
        return "inp";
    }

}