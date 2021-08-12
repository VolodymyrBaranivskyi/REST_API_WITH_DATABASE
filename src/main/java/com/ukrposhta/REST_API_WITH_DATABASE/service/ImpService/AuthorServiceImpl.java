package com.ukrposhta.REST_API_WITH_DATABASE.service.ImpService;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import com.ukrposhta.REST_API_WITH_DATABASE.repository.AuthorRepository;
import com.ukrposhta.REST_API_WITH_DATABASE.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
    @Override
    public Author getAuthorById(long authorId) {
        return authorRepository.findById(authorId).get();
    }

    @Override
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @Override
    public void updateAuthor(Author author) {
        // check if the user with the passed id exists or not
        Author authorDB = authorRepository.findById(author.getId()).orElseThrow();
        // If user exists then updated
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(long authorId) {
        try {
            authorRepository.deleteById(authorId);
        }catch(DataAccessException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    @Query("select * from authors a inner join authors_books ab on a.author_id = ab.author_id inner join books b on ab.book_id = b.book_id   where b.title LIKE '%One%'")
    public List<Author> getAuthorsByBookTitle(String titleString) {
        return authorRepository.getAuthorsByBookPartTitle(titleString);
    }
}

