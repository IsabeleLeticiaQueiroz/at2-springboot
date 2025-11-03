package com.isabele.at2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DisciplinaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testeListarDisciplinas() {
        ResponseEntity<Disciplina[]> response = restTemplate.getForEntity("/disciplinas", Disciplina[].class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().length >= 2);
    }
}
