package com.ukrposhta.REST_API_WITH_DATABASE.repository;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
