package com.flag.flagapp;

import com.flag.flagapp.dto.Country;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class FlagImageDownloader {

    private static String FIRST_PART_PATH_LINUX = "/tmp/countries/flags";
    private static String FIRST_PART_PATH_WINDOWS = "C:\\tmp\\countries\\flags";

    public static void downloadFlags(final Country country)  {
        try {
            final String fullPath;
            final URL flagURL = new URL(country.getFlags().getPng());
            final BufferedImage flagImage = ImageIO.read(flagURL);

            if (File.separator.equals("/")) {
                fullPath = FIRST_PART_PATH_LINUX + File.separator + country.getName();
            } else {
                fullPath = FIRST_PART_PATH_WINDOWS + File.separator + country.getName();
            }

            File file = new File(fullPath);
            ImageIO.write(flagImage, "png", file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
