package task_4;

public class Main {

    public static void main(String[] args) {
        Mfu mfu = new Mfu();

        Printer printer = new Printer(mfu,30);
        Printer printer1 = new Printer(mfu, 80);
        Printer printer2 = new Printer(mfu,20);
        Scanner scanner = new Scanner(mfu, 30);
        Scanner scanner1 = new Scanner(mfu, 50);

        mfu.start();
    }
}
