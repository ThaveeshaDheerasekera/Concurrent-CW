/**
 * *************************************************************
 * File:	    TonerTechnician.java (Class)
 * Author:	    Thaveesha Dheerasekera; IIT ID: 2019483; UoW ID: w1761369
 * Contents:    Concurrent Programming Coursework (2022/23)
 * Description: This provides the functions of toner technician.
 * Date:	    06-Jan-23
 * Version:	    1.0
 * *************************************************************
 */

public class TonerTechnician extends Thread {
    private final ServicePrinter printer;

    TonerTechnician(String technicianName, ServicePrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + technicianName);
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            printer.replaceTonerCartridge();
            try {
                sleep(Utilities.timeRandomizer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
