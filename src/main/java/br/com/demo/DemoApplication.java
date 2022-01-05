package br.com.demo;


import br.com.demo.entities.Author;
import br.com.demo.entities.Book;
import br.com.demo.repository.AuthorRepository;
import br.com.demo.services.AuthorService;
import br.com.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication

public class DemoApplication {




    public static void main(String[] args) {


        SpringApplication.run(DemoApplication.class, args);
    }

}
