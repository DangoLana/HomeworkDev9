package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {

    private final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter HTTP status code: ");

        String input = scanner.nextLine();

        try {
            int statusCode = Integer.parseInt(input);
            downloadImageForStatus(statusCode);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        }
    }

    private void downloadImageForStatus(int code) {
        try {
            downloader.downloadStatusImage(code);
        } catch (Exception e) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}