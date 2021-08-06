package task_4;

public class Scanner extends Thread{
    private final int pagesQuantity;
    private final Mfu mfu;

    public Scanner(Mfu mfu, int pagesQuantity) {
        this.pagesQuantity = pagesQuantity;
        this.mfu = mfu;
        mfu.addScanner(this);
    }

    @Override
    public void run() {
        synchronized (mfu.lockScanners){
            for (int i = 1; i < pagesQuantity + 1; i++) {
                System.out.printf("Отсканировано %d стр.%n", i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
