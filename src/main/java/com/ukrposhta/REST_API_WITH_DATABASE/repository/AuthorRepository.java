package com.ukrposhta.REST_API_WITH_DATABASE.repository;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Author findAll(int id);

}
