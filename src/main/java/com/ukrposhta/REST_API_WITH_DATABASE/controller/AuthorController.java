package com.ukrposhta.REST_API_WITH_DATABASE.controller;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import com.ukrposhta.REST_API_WITH_DATABASE.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Author>> getAuthors(){
        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK)
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Author>> getAuthor(@PathVariable int id){
        Author author = authorRepository.findOne(id);

        if(author != null) {
            return new ResponseEntity<>(authorRepository.findOne(id), HttpStatus.OK)
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
