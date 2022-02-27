package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    String[] strings = {"-", "\\",   "|",  "/" };

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            for (String str : strings) {
            System.out.print("\r load: " + str);
            try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
