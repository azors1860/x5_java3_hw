package task_1;

public class Task_1 {

    public static void main(String[] args){
        Object lock = new Object();
        Thread ping = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        lock.notify();
                        System.out.println("ping");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread pong = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        lock.notify();
                        System.out.println("pong");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        ping.start();
        pong.start();
    }
}
