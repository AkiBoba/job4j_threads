package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    int count = 0;
    String symbol = null;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            count++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            symbol = count % 2 == 0 ? "\\| " : " |/";
            System.out.print("\r load: " + symbol);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
