package com.ukrposhta.REST_API_WITH_DATABASE.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_id_seq")
    @SequenceGenerator(name = "authors_id_seq", sequenceName = "authors_id_seq", initialValue = 4, allocationSize = 1)
    private Long id;

    @Column(name = "isbn")
    private String firstName;

    @Column(name = "isbn")
    private String secondName;

    @Column(name = "isbn")
    private String lastName;

    @Column(name = "isbn")
    private Date birth_date;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "authors_books",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") })
    private Set<Book> books = new HashSet<>();


    @Override
    public String toString() {
        return "Author [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", lastName=" + lastName + ", birth_date=" + birth_date+ "]";
    }
}
