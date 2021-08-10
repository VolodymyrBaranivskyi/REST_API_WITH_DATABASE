package com.ukrposhta.REST_API_WITH_DATABASE.controller;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Book;
import com.ukrposhta.REST_API_WITH_DATABASE.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Book>> getBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        Book book = bookRepository.findOne(id);

        if (book != null) {
            return new ResponseEntity<>(bookRepository.findOne(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookRepository.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /*
    @RequestMapping(value = {"/books"}, method = RequestMethod.GET)
    public ModelAndView allBooks() {
        ModelAndView modelAndView = new ModelAndView("books/home"); //viewname przekazujemy z folderu templates
        List<Book> book = bookService.getAllBooks();
        modelAndView.addObject("books",book);  //ta nazwa tutaj "books" sluzy potem do wykorzystania jej w templacie
        return modelAndView;
    }
    */