package com.flag.flagapp.request;

import com.flag.flagapp.dto.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RequestToRestcountries {

    @Value("${URL}")
    private String FIRST_PART_URL;

    public List<Country> getCountryList(String countiesCodes) {
        String URL = FIRST_PART_URL + countiesCodes;
        RestTemplate restTemplate = new RestTemplate();
        final var responseEntity = restTemplate.getForEntity(URL, Country[].class);
        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody())).collect(Collectors.toList());
    }
}
