package com.ukrposhta.REST_API_WITH_DATABASE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.ukrposhta.REST_API_WITH_DATABASE.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiWithDatabaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllAuthor() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/author",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testAuthorById() {
        Author author = restTemplate.getForObject(getRootUrl() + "/author/1", Author.class);
        System.out.println(author.getFirstName());
        assertNotNull(author);
    }

    @Test
    public void testCreateAuthor() {
        Author author = new Author();
        author.setFirstName("admin");
        author.setLastName("admin");
        LocalDate birthDate = LocalDate.of(Integer.parseInt("1945"), Integer.parseInt("4"), Integer.parseInt("7"));
        author.setBirth_date(birthDate);
        ResponseEntity<Author> postResponse = restTemplate.postForEntity(getRootUrl() + "/author", author, Author.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateAuthor() {
        int id = 1;
        Author author = restTemplate.getForObject(getRootUrl() + "/author/" + id, Author.class);
        author.setFirstName("admin1");
        author.setLastName("admin2");
        restTemplate.put(getRootUrl() + "/author/" + id, author);
        Author updatedAuthor = restTemplate.getForObject(getRootUrl() + "/author/" + id, Author.class);
        assertNotNull(updatedAuthor);
    }

    @Test
    public void testDeleteAuthor() {
        int id = 2;
        Author author = restTemplate.getForObject(getRootUrl() + "/author/" + id, Author.class);
        assertNotNull(author);
        restTemplate.delete(getRootUrl() + "/author/" + id);
        try {
            author = restTemplate.getForObject(getRootUrl() + "/author/" + id, Author.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAuthorsByBookPartTitle() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/author/search-author" + "One",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAuthorsByBookPartTitleValue() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/author/search-author" + "/One",
                HttpMethod.GET, entity, String.class);
        //Convert to JSON
        Gson gson = new Gson();
        List<Author> authorList = gson.fromJson(response.getBody(), List.class);
        System.out.println("test: " + authorList.stream().count());
        assertEquals(authorList.stream().count(), 2);
    }


}
