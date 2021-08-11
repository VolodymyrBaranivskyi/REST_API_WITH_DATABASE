package com.ukrposhta.REST_API_WITH_DATABASE.controller;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Book;
import com.ukrposhta.REST_API_WITH_DATABASE.servive.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addAuthor(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    // Fetch all book records
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    // Fetch single book
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") long bookId){
        return bookService.getBookById(bookId);
    }
    // Update book record
    @PutMapping("/update-book")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        try {
            bookService.updateBook(book);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(NoSuchElementException ex){
            // log the error message
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete book record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id){
        try {
            bookService.deleteBookById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            // log the error message
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}






