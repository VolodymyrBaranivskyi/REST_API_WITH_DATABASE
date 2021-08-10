package com.ukrposhta.REST_API_WITH_DATABASE.servive.ImpService;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Book;
import com.ukrposhta.REST_API_WITH_DATABASE.repository.BookRepository;
import com.ukrposhta.REST_API_WITH_DATABASE.servive.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book findOne(int id) {
        return bookRepository.findById((long)id);
    }
}
