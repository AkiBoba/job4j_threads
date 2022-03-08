package ru.job4j.pool;

import ru.job4j.queue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(size);

    /**
     * добавляем задачи tasks.offer(job); потоков в кол-ве size согласно условию
     * Проверяем состояние флага Thread.currentThread().isInterrupted()
     * возвращаем объект из внутренней коллекции
     * заполняем жобами блок.очередь
     * и при этом каждую нить надо запустить
     */
    public ThreadPool() {
        for (int i = 0; i < size; i++) {
            threads.add(new Thread(
                    () -> {
                        try {
                            while (!Thread.currentThread().isInterrupted()) {
                                Runnable task = tasks.poll();
                                System.out.println("task -" + task);
                                task.run();
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
            ));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    /**
     * метод добавляет задачи в блокирующую очередь tasks
     * @param job на входе задача которую надо добавить в блок.очередь
     * @throws InterruptedException исключение вынесли в метод
     *
     */

    public void work(Runnable job) throws InterruptedException {
        tasks.offer(job);
    }

    /**
     * завершаем все потоки
     */
    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        threadPool.work(() -> System.out.println("first"));
        threadPool.work(() -> System.out.println("second"));
        threadPool.work(() -> System.out.println("third"));
        threadPool.work(() -> System.out.println("forth"));
        threadPool.work(() -> System.out.println("five"));
        threadPool.work(() -> System.out.println("6"));
        threadPool.work(() -> System.out.println("7"));
        threadPool.work(() -> System.out.println("8"));
        threadPool.work(() -> System.out.println("9"));
        threadPool.work(() -> System.out.println("10"));
        threadPool.shutdown();
    }
}