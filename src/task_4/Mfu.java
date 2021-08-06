package task_4;

import java.util.ArrayList;
import java.util.List;

public class Mfu {
    private final List<Printer> printers = new ArrayList<>();
    private final List<Scanner> scanners = new ArrayList<>();

    public final Object lockPrinters = new Object();
    public final Object lockScanners = new Object();

    public void addPrinter(Printer printer) {
        printers.add(printer);
    }

    public void addScanner(Scanner scanner) {
        scanners.add(scanner);
    }

    public void start() {
        for (Printer printer : printers) {
            printer.start();
        }
        for (Scanner scanner : scanners) {
            scanner.start();
        }
    }
}
