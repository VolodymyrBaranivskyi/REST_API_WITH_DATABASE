package com.ukrposhta.REST_API_WITH_DATABASE.repository;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
