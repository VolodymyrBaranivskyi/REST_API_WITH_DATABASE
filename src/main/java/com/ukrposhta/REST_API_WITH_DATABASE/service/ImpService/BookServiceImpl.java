package com.ukrposhta.REST_API_WITH_DATABASE.service.ImpService;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Book;
import com.ukrposhta.REST_API_WITH_DATABASE.repository.BookRepository;
import com.ukrposhta.REST_API_WITH_DATABASE.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public void updateBook(Book book) {
        // check if the user with the passed id exists or not
        Book authorDB = bookRepository.findById(book.getId()).orElseThrow();
        // If user exists then updated
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(long bookId) {
        try {
            bookRepository.deleteById(bookId);
        }catch(DataAccessException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
