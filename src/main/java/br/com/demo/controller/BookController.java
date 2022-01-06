package br.com.demo.controller;


import br.com.demo.entities.Author;
import br.com.demo.entities.Book;
import br.com.demo.services.AuthorService;
import br.com.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd(){
        ModelAndView mv = new ModelAndView("bookform");
        List<Author> authorList = authorService.getAuthorList();
        mv.addObject("authorList",authorList);
        return mv;
    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            redirect.addFlashAttribute("Mensagem","Verifique os campos obrigatórios");
            return "redirect:/book/form/add";
        }
        bookService.save(book);
        return "redirect:/lista";

    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable("id") Long id){

        ModelAndView mv = new ModelAndView("bookform");
        List<Author> authorList = this.authorService.getAuthorList();
        mv.addObject("authorList", authorList);

        Book book = bookService.findById(id);

        mv.addObject("book", book);

        return mv;

    }

    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable("id") Long id){
        bookService.delete(id);
        return "redirect:/lista";
    }


}
