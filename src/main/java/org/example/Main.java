package org.example;


public class Main {
    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            System.out.println("Status 200: " + checker.getStatusImage(200));
            System.out.println("Status 404: " + checker.getStatusImage(404));
            System.out.println("Status 10000: " + checker.getStatusImage(10000));
        } catch (Exception e1) {
            System.err.println(e1.getMessage());
        }


        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        try {
            downloader.downloadStatusImage(200);
            downloader.downloadStatusImage(404);
            downloader.downloadStatusImage(10000);
        } catch (Exception e2) {
            System.err.println("Error: " + e2.getMessage());
        }


//        HttpImageStatusCli cli = new HttpImageStatusCli();
//        cli.askStatus();
    }
}