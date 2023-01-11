/**
 * *************************************************************
 * File:        PaperTechnician.java (Class)
 * Author:      Thaveesha Dheerasekera; IIT ID: 2019483; UoW ID: w1761369
 * Contents:    6SENG006C Concurrent Programming Coursework (2022/23)
 * Description: This provides the functions of paper technician.
 * Date:        06-Jan-23
 * Version:     1.0
 * *************************************************************
 */

public class PaperTechnician extends Thread {
    private final ServicePrinter printer;

    PaperTechnician(String technicianName, ServicePrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + technicianName);
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            printer.refillPaper();
            try {
                sleep(Utilities.timeRandomizer()); // Sleeping for random time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
