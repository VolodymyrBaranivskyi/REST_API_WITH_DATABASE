package com.ukrposhta.REST_API_WITH_DATABASE.servive;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Book;

public interface BookService {

    public Book findOne(int id);
}