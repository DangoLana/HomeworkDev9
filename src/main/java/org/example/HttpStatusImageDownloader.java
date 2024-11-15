package org.example;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker statusChecker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws Exception {
        String imageUrl = statusChecker.getStatusImage(code);
        String fileName = code + ".jpg";

        try (InputStream in = new URL(imageUrl).openStream();
             FileOutputStream out = new FileOutputStream(fileName)) {

            System.out.println("Downloading image from: " + imageUrl);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Image saved as: " + fileName);
        } catch (IOException e) {
            throw new IOException("Failed to download or save the image.", e);
        }
    }
}