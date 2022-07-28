package com.flag.flagapp.service;

import com.flag.flagapp.Downloader;
import com.flag.flagapp.dto.Country;
import com.flag.flagapp.request.RequestToRestcountries;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    @Override
    public void saveFlags(String countriesCodes) {
        request.getCountryList(countriesCodes).parallelStream().forEach(country -> {
            try {
                Downloader.downloadFiles(country);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
