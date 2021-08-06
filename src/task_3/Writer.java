package task_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class Writer extends Thread {

    private final Object lock = new Object();

    public void writer(String str) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Task3File.txt"), true))) {
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write(str);
                bufferedWriter.flush();
                Thread.sleep(20);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (lock) {
            lock.notify();
            writer(Thread.currentThread().getName() + "\n");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Writer writer = new Writer();
        Writer writer1 = new Writer();
        Writer writer2 = new Writer();
        writer.start();
        writer1.start();
        writer2.start();
    }
}



