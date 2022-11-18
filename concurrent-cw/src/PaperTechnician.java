public class PaperTechnician implements Runnable {
    private final String name;
    private final ThreadGroup group;
    private final ServicePrinter printer;

    public PaperTechnician(String name, ThreadGroup group, ServicePrinter printer) {
        this.name = name;
        this.group = group;
        this.printer = printer;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            printer.refillPaper();

            if (((LaserPrinter)printer).isPaperRefilled()) {
                count++;
            }
            int num = ((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Paper Technician Finished. " + count + " Pack of Papers Used.");
        }
    }
}
