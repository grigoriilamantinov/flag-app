package com.flag.flagapp.dowloader;

import com.flag.flagapp.dto.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class FlagImageDownloader {

    @Value("${LINUX_PATH}")
    private String FIRST_PART_PATH_LINUX;
    @Value("${WINDOWS_PATH}")
    private String FIRST_PART_PATH_WINDOWS;
    @Value("${FORMAT_NAME}")
    private String FORMAT_NAME;

    public void downloadFlags(final Country country)  {
        try {
            final URL flagURL = new URL(country.getFlags().getPng());
            final BufferedImage flagImage = ImageIO.read(flagURL);

            final String fullPath = File.separator.equals("/")
                ? FIRST_PART_PATH_LINUX + File.separator + country.getName()
                : FIRST_PART_PATH_WINDOWS + File.separator + country.getName() + ".png";

            File file = new File(fullPath);
            ImageIO.write(flagImage, FORMAT_NAME, file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
