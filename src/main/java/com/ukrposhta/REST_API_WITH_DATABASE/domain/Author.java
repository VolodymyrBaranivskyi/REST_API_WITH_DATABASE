package com.ukrposhta.REST_API_WITH_DATABASE.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Клас автора зі властивостями <b>author_id</b>, <b>firstName</b>,  <b>second_name</b>,  <b>last_name</b>,  <b>birth_date</b> и <b>bookList</b>.
 * @autor Баранівський Володимир
 * @version 1.0
 */

@Data
@Entity
@Table(name = "authors")
public class Author {

    /** Поле ідентифікатор */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_id_seq")
    @SequenceGenerator(name = "authors_id_seq", sequenceName = "authors_id_seq", initialValue = 4, allocationSize = 1)
    @Column(name = "author_id")
    private Long id;

    /** Поле ім'я */
    @Column(name = "first_name")
    private String firstName;

    /** Поле по батькові */
    @Column(name = "second_name")
    private String secondName;

    /** Поле прізвище */
    @Column(name = "last_name")
    private String lastName;

    /** Поле день нардження */
    @Column(name = "birth_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate birth_date;

    /** Поле список всіх книг автора */
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(
            name = "authors_books",
            joinColumns = {
                    @JoinColumn(name = "author_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id")
            }
    )
    private List<Book> bookList;


    /**
     * Перевизначена функця переведення значення всіх властивостей в рядок
     * @return повертає рядок
     */
    @Override
    public String toString() {
        return "Author [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", lastName=" + lastName + ", birth_date=" + birth_date+ "]";
    }
}
