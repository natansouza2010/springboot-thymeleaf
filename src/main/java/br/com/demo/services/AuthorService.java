package br.com.demo.services;

import br.com.demo.entities.Author;
import br.com.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthorList(){
        Iterable<Author> all = authorRepository.findAll();
        return Streamable.of(all).toList();
    }

    public boolean save(Author author){
        authorRepository.save(author);
        return true;
    }


}
