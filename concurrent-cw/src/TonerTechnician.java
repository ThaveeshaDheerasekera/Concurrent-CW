public class TonerTechnician implements Runnable {
    private final String name;
    private final ThreadGroup group;
    private final ServicePrinter printer;

    public TonerTechnician(String name, ThreadGroup group, ServicePrinter printer) {
        this.name = name;
        this.group = group;
        this.printer = printer;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            printer.replaceTonerCartridge();

            if (((LaserPrinter)printer).isTonerReplaced()) {
                count++;
            }
            int num = ((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Toner Technician Finished. " + count + " Cartridges Used.");
        }
    }
}
