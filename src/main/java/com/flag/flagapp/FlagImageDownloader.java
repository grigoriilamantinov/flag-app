package com.flag.flagapp;

import com.flag.flagapp.dto.Country;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class FlagImageDownloader {

    private static String FIRST_PART_PATH = "/tmp/countries/flags";

    public static void downloadFlags(final Country country)  {
        try {
            final URL flagURL = new URL(country.getFlags().getPng());
            final BufferedImage flagImage = ImageIO.read(flagURL);
            final String fullPath = FIRST_PART_PATH + File.separator + country.getName();
            File file = new File(fullPath);
            ImageIO.write(flagImage, "png", file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
