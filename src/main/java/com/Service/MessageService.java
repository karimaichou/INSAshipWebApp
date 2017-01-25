package com.Service;


import com.entities.Application;
import com.entities.Student;
import com.entities.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franck-Gravouil on 21/01/2017.
 */
@Service
public class MessageService {
    private static final String urlMessageService= "http://localhost:8181/api/sendmessage";

    // Mail type 1 = Mail with confirmation code
    public void sendCodeConfirmMessage(Student student) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlMessageService)
                .queryParam("type", 1)
                .queryParam("email", student.getEmail())
                .queryParam("name", student.getFirstName())
                .queryParam("extra", student.getToken());

        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
    }
}
