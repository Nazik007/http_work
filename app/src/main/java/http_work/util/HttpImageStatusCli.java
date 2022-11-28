package http_work.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    private static final HttpStatusImageDownloader HTTP_STATUS_IMAGE_DOWNLOADER = new HttpStatusImageDownloader();
    private static final HttpImageStatusCli HTTP_IMAGE_STATUS_CLI = new HttpImageStatusCli();

   public void askStatus() {
       try (Scanner scanner  = new Scanner(System.in)) {
           System.out.println("Please, type in the HTTP status code");

           int code = 0;
           try {
               code =scanner.nextInt();
           }catch (InputMismatchException ex) {
               System.err.println("Please, enter a valid status number");
               HTTP_IMAGE_STATUS_CLI.askStatus();
           }

           HTTP_STATUS_IMAGE_DOWNLOADER.downloadStatusImage(code);
           HTTP_IMAGE_STATUS_CLI.askStatus();

       }catch (InputMismatchException ex) {
           ex.printStackTrace();
       }
   }


}
