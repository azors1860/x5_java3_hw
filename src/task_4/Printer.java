package task_4;

public class Printer extends Thread {
    private final int pagesQuantity;
    private final Mfu mfu;

    public Printer(Mfu mfu, int pagesQuantity) {
        this.pagesQuantity = pagesQuantity;
        this.mfu = mfu;
        mfu.addPrinter(this);
    }

    @Override
    public void run() {
        synchronized (mfu.lockPrinters) {
            for (int i = 1; i < pagesQuantity + 1; i++) {
                System.out.printf("Отпечатано %d стр.%n", i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
