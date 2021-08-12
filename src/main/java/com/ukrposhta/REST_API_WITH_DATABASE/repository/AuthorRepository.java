package com.ukrposhta.REST_API_WITH_DATABASE.repository;

import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query(value = "select * from authors a inner join authors_books ab on a.author_id = ab.author_id inner join books b on ab.book_id = b.book_id   where b.title LIKE %:titleString%", nativeQuery=true)
    public List<Author> getAuthorsByBookPartTitle(@Param("titleString") String titleString);
}
