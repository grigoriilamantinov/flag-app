package com.flag.flagapp.service;

import com.flag.flagapp.FlagImageDownloader;
import com.flag.flagapp.request.RequestToRestcountries;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class FlagServiceImpl implements FlagService {
    final RequestToRestcountries request;
    final FlagImageDownloader downloader;

    @Value("${LINUX_PATH}")
    private String LINUX_PATH;

    @Value("${WINDOWS_PATH}")
    private String WINDOWS_PATH;

    @Override
    public void saveFlags(final String countriesCodes) {
        this.createDir();
        request.getCountryList(countriesCodes).parallelStream()
            .forEach(downloader::downloadFlags);
    }

    private void createDir() {
        final File file = File.separator.equals("/")
            ? new File(LINUX_PATH)
            : new File(WINDOWS_PATH);

        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
