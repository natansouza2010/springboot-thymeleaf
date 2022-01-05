package br.com.demo.controller;


import br.com.demo.entities.Author;
import br.com.demo.entities.Book;
import br.com.demo.services.AuthorService;
import br.com.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/lista")
    public ModelAndView getList(){


        List<Book> bookList  = bookService.findAll();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("bookList",bookList);
        return mv;
    }

}
