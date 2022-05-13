package com.spring.bookinventory.DAO;

import com.spring.bookinventory.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByGenre(String genre);
}

abstract class BookRepoImplementation implements BookRepository{


    @Override
    public List<Book> findByGenre(String genre) {
        return null;
    }
}
