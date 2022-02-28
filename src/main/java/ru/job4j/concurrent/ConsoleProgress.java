package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {

    @Override
    public void run() {

        String[] strings = {"-", "\\",   "|",  "/" };
        int ind = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\r load: " + strings[ind++]);
            try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if (ind == strings.length) {
                ind = 0;
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
