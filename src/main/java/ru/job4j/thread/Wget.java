package ru.job4j.thread;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Wget implements Runnable {
    private final String url;
    private final int speed;
    private final String fileTo;

    public Wget(String url, int speed, String fileTo) {
        this.url = url;
        this.speed = speed;
        this.fileTo = fileTo;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileTo)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            int downloadData = 0;
            long start = System.currentTimeMillis();
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                downloadData += bytesRead;
                if (downloadData >= speed) {
                    if (System.currentTimeMillis() - start < 1000) {
                        try {
                            Thread.sleep(1000 - (System.currentTimeMillis() - start));

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    downloadData = 0;
                    start = System.currentTimeMillis();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void validate(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    "Аргументы введены некорректно. Для правильной работы программы следует ввести три аргумента через пробел:"
                            + System.lineSeparator()
                            +  "2) типа int - количество миллисекунд  - скорость скачивания"
                            +  System.lineSeparator()
                            + "3) типа String - имя файла для созраниения скаченного контента"
                            + System.lineSeparator()
                            + "Пример: https://proof.ovh.net/files/10Mb.dat 5000 pom_tmp.xml"
            );
        }
    }

    public static void main(String[] args) throws InterruptedException {
        validate(args);
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        String fileTo = args[2];
        Thread wget = new Thread(new Wget(url, speed, fileTo));
        wget.start();
        wget.join();
    }
}