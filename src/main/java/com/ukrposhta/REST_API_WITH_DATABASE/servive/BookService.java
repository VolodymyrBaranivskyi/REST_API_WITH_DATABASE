package com.ukrposhta.REST_API_WITH_DATABASE.servive;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public Book addBook(Book book);
    public Book getBookById(long bookId);
    public List<Book> getAllBooks();
    public void updateBook(Book book);
    public void deleteBookById(long bookId);
}