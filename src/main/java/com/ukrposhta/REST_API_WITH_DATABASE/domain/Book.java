package com.ukrposhta.REST_API_WITH_DATABASE.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


/**
 * Клас книги зі властивостями <b>author_id</b>, <b>firstName</b>,  <b>second_name</b>,  <b>last_name</b>,  <b>birth_date</b> и <b>bookList</b>.
 * @autor Баранівський Володимир
 * @version 1.0
 */
@Data
@Entity
@Table(name = "books")
public class Book {

    /** Поле ідентифікатор */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_id_seq")
    @SequenceGenerator(name = "authors_id_seq", sequenceName = "authors_id_seq", initialValue = 4, allocationSize = 1)
    @Column(name = "book_id")
    private Long id;

    /** Поле міжнародний стандартний номер книги */
    @Column(name = "isbn")
    private String isbn;

    /** Поле кількість сторінок */
    @Column(name = "page_count")
    private int page_count;

    /** Поле дата публікації */
    @Column(name = "publish_date")
    private LocalDate publish_date;


    /** Поле назва книги */
    @Column(name = "title")
    private String title;

    /** Поле назва книги в оригіналі */
    @Column(name = "title_original")
    private String title_original;

    /** Поле список всіх авторів книги */
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "bookList")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Author> authors;

}




