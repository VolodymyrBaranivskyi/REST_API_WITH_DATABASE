package com.ukrposhta.REST_API_WITH_DATABASE.servive;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    public Author addAuthor(Author author);
    public Author getAuthorById(long authorId);
    public List<Author> getAllAuthors();
    public void updateAuthor(Author author);
    public void deleteAuthorById(long authorId);

}
