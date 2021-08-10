package com.ukrposhta.REST_API_WITH_DATABASE.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_id_seq")
    @SequenceGenerator(name = "authors_id_seq", sequenceName = "authors_id_seq", initialValue = 4, allocationSize = 1)
    private Long id;

    private String firstName;
    private String secondName;
    private String lastName;
    private String age;
    private Date birth_date;
}
