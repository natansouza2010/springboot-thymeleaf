package br.com.demo.services;

import br.com.demo.entities.Book;
import br.com.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Book findById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

}
