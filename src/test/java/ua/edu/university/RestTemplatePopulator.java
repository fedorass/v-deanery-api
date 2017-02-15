package ua.edu.university;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ua.edu.university.data.model.Faculty;

import java.util.HashMap;
import java.util.Map;

public class RestTemplatePopulator {

    private RestTemplate restTemplate;
    private HttpHeaders headers;

    private static final String BASE_FACULTIES_URL = "http://127.0.0.1:8080/api/faculties";
    private static final String BASE_DEPARTMENTS_URL = "http://127.0.0.1:8080/api/departments";

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.add("Authorization", "Basic Z3Vlc3Q6Z3Vlc3Q=");
    }

    @Test
    public void populateFacultiesDepartmentsAssociation() {
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Faculty> result = restTemplate.exchange(BASE_FACULTIES_URL + "/{id}", HttpMethod.GET, request, Faculty.class, params);

        System.out.println(result.getBody().getName());
        //restTemplate.getForEntity(BASE_FACULTIES_URL + "/{id}", Faculty.class, params);
    }

}
