package com.test.personservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class PersonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/person")
    public String getPerson(){
        try {
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/address", String.class);
            return response.getBody();
        }catch (ResourceAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
