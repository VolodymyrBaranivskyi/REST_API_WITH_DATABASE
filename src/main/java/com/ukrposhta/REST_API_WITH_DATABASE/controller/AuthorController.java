package com.ukrposhta.REST_API_WITH_DATABASE.controller;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import com.ukrposhta.REST_API_WITH_DATABASE.servive.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
    // Fetch all author records
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    // Fetch single author
    @GetMapping("/{id}")
    public Author getBookById(@PathVariable("id") long authorId){
        return authorService.getAuthorById(authorId);
    }
    // Update user record
    @PutMapping("/update-author")
    public ResponseEntity<String> updateUser(@RequestBody Author author) {
        try {
            authorService.updateAuthor(author);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(NoSuchElementException ex){
            // log the error message
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete author record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable long id){
        try {
            authorService.deleteAuthorById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            // log the error message
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}


