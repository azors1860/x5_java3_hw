package task_2;

import java.util.Random;

public class Task_2 {
    private final static Random random = new Random();
    private static int informationPackage;
    private final Object lock = new Object();

    private void send() {
        synchronized (lock) {
            while (true) {
                lock.notify();
                int x = random.nextInt(100_000_000);
                while (true) {
                    if (random.nextInt(100_000_000) == x) {
                        informationPackage = x;
                        break;
                    }
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void receive() {
        synchronized (lock) {
            while (true) {
                lock.notify();
                System.out.println(informationPackage);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        Task_2 task = new Task_2();

        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                task.send();
            }
        });
        sender.start();

        Thread receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                task.receive();
            }
        });
        receiver.start();
    }
}