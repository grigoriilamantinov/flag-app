package com.flag.flagapp.service;

import com.flag.flagapp.FlagImageDownloader;
import com.flag.flagapp.request.RequestToRestcountries;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FlagServiceImpl implements FlagService {
    final RequestToRestcountries request;

    @Value("${PATH}")
    private String PATH;

    public FlagServiceImpl(RequestToRestcountries request) {
        this.request = request;
    }

    @Override
    public void saveFlags(final String countriesCodes) {
        this.createDir();
        request.getCountryList(countriesCodes).parallelStream()
            .forEach(FlagImageDownloader::downloadFlags);
    }

    private void createDir() {
        File file = new File(PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
