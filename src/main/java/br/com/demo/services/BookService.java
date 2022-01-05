package br.com.demo.services;

import br.com.demo.entities.Book;
import br.com.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public List<Book> findAll(){
        Iterable<Book> booksIterable = bookRepository.findAll();
        return Streamable.of(booksIterable).toList();

    }

}
