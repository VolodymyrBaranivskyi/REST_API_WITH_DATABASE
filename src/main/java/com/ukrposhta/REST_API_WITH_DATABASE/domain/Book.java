package com.ukrposhta.REST_API_WITH_DATABASE.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_id_seq")
    @SequenceGenerator(name = "authors_id_seq", sequenceName = "authors_id_seq", initialValue = 4, allocationSize = 1)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "page_count")
    private int page_count;

    @Column(name = "publish_date")
    private Date publish_date;

    @Column(name = "title")
    private String title;

    @Column(name = "title_original")
    private String title_original;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

}




