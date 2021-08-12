package com.ukrposhta.REST_API_WITH_DATABASE.controller;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import com.ukrposhta.REST_API_WITH_DATABASE.service.AuthorService;
import com.ukrposhta.REST_API_WITH_DATABASE.service.ImpService.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;


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
    // Fetch all author records
    @GetMapping("/search-author/{titleString}")
    public List<Author> getAllAuthorsByConsistTitleString(@PathVariable("titleString") String titleString){
        System.out.println("Query: " + titleString);
        return authorService.getAuthorsByBookTitle(titleString);
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


