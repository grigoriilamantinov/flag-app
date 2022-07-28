package com.flag.flagapp.service;

import com.flag.flagapp.FlagImageDownloader;
import com.flag.flagapp.request.RequestToRestcountries;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FlagServiceImpl implements FlagService {
    final RequestToRestcountries request;

    @Value("${LINUX_PATH}")
    private String LINUX_PATH;

    @Value("${WINDOWS_PATH}")
    private String WINDOWS_PATH;

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
        File file;
        if (File.separator.equals("/")) {
            file = new File(LINUX_PATH);
        } else {
            file = new File(WINDOWS_PATH);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
