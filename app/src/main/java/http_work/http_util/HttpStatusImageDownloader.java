package http_work.http_util;

import http_work.IncorrectInputException;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {

    private static final HttpStatusChecker HTTP_STATUS_CHECKER = new HttpStatusChecker();

    void downloadStatusImage(int code) throws IncorrectInputException {

        String uri = HTTP_STATUS_CHECKER.getStatusImage(code);

        try {

            URL url = new URL(uri);

            File dir = new File("Cat_Images");
            dir.mkdir();

            String fileName = "Cat" + code + ".jpg";
            String fileDestinationFolder = "../http_work/Cat_Images/";

            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(fileDestinationFolder + fileName);

            byte [] buffer = new byte[2048];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();

            System.out.println("The image of cat with code " + code + " was downloaded");

        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }
}
