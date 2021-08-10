package com.ukrposhta.REST_API_WITH_DATABASE.repository;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Author, Long> {
    public Author findAll(int id);
}
