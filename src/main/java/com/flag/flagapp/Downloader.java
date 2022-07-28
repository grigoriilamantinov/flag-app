package com.flag.flagapp;

import com.flag.flagapp.dto.Country;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Downloader {

    private static String FIRST_PART_PATH = "/tmp/countries/flags";

    public static void downloadFiles(Country country) throws IOException {
        final URL flagURL = new URL(country.getFlags().getPng());
        final BufferedImage img = ImageIO.read(flagURL);
        String fullPath = FIRST_PART_PATH + File.separator + country.getName();
        File file = new File(fullPath);
//        file.mkdir();
//        Path path = Paths.get(PATH);
//        Files.createDirectory(path);
        ImageIO.write(img, "png", file);

    }
}
