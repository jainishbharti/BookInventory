package com.spring.bookinventory.controller;

import com.spring.bookinventory.DAO.BookRepository;
import com.spring.bookinventory.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping(path="/book", consumes="application/json")
    public Book add(@RequestBody Book book){
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(path="/books")
    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(path="/book/{bookId}")
    public Optional<Book> getBookById(@PathVariable Integer bookId){
        return bookRepository.findById(bookId);
    }

    @PutMapping(path="/book")
    public Book saveOrUpdateBook(@RequestBody Book book){
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping(path = "/book/{bookId}")
    public String deleteBook(@PathVariable Integer bookId){
        bookRepository.deleteById(bookId);
        return "{\"message\" : \"Entity deleted successfully\"}";
    }

    @RequestMapping(path="/book/{genre}")
    public List<Book> getBookByGenre(@PathVariable String genre){
        return bookRepository.findByGenre(genre);
    }

}
