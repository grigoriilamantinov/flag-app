package com.flag.flagapp.service;

import com.flag.flagapp.dto.Country;
import com.flag.flagapp.request.RequestToRestcountries;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlagServiceImpl implements FlagService {
    final RequestToRestcountries request;

    public FlagServiceImpl(RequestToRestcountries request) {
        this.request = request;
    }

    @Override
    public List<Country> getCountries(String countriesCodes) {
        return request.getCountryList(countriesCodes);
    }

    public void saveFlags(String countriesCodes) {
        var result = request.getCountryList(countriesCodes).stream()
            .map(country -> country.getFlags().getPng())
            .collect(Collectors.toList());
        result.forEach(flag -> String.valueOf(flag));

    }
}
