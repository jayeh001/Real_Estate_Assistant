package com.investing.start.controllers;
import org.slf4j.LoggerFactory;
//import org.slf4j.logger;
import org.slf4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
//makes a GET request to Rentcast API and returns json data back to Home Controller
@RestController
public class ExternalApiController {

    @Value("${external.api.key}")
    private String apiKey;

    private static final Logger log = LoggerFactory.getLogger(ExternalApiController.class);

    private final RestTemplate restTemplate;

    public ExternalApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getHouseData(String address) {

        log.info("entered ExternalApiController.getHouseData");
        log.info("address after entering ExternalApiController: {}", address);

        String externalApiUrl = "https://api.rentcast.io/v1/avm/value";

        //build a url with query params
        URI uri = UriComponentsBuilder.fromUriString(externalApiUrl).queryParam("address", address).build().toUri();
        //Set up request headers
        HttpHeaders headers = new HttpHeaders();

        headers.add("X-Api-Key", apiKey);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        log.info("Calling url: {}", uri);
        log.info("Header is: {}", headers.toString());
        log.info("entity is {}", entity.toString());

        try {
            log.info("inside try statement, url is: {}", uri);
            ResponseEntity<Map<String,Object>> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<>() {
                    });

            Map<String, Object> data = response.getBody();
            assert data != null;
            System.out.println("property id is " + data.get("price"));
            return data;

        } catch (RestClientException e) {
            log.error("error processing Json Response: {}", e.getMessage(), e);
            return new HashMap<>();
        }
    }
}

