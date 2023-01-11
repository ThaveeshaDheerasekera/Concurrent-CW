/**
 * *************************************************************
 * File:        PrintingSystem.java (Class)
 * Author:      Thaveesha Dheerasekera; IIT ID: 2019483; UoW ID: w1761369
 * Contents:    6SENG006C Concurrent Programming Coursework (2022/23)
 * Description: This provides the functions of the printing system. The main class
 * Date:        06-Jan-23
 * Version:     1.0
 * *************************************************************
 */

public class PrintingSystem {
    public static void main(String[] params) {

        System.out.println("\n\n----BEGIN------------------------------------------------------------------\n");
        System.out.println("\t*\tAuthor:\t\tThaveesha Dheerasekera; IIT ID: 2019483; UoW ID: w1761369");
        System.out.println("\t*\tContent:\t6SENG006C Concurrent Programming Coursework (2022/23)");
        System.out.println("\t*\tVersion:\t1.0");
        System.out.println("\n---------------------------------------------------------------------------\n");

        // Required threads
        ThreadGroup studentThreads = new ThreadGroup("StudentGroup");
        ThreadGroup technicianThreads = new ThreadGroup("TechnicianGroup");

        ServicePrinter printer = new LaserPrinter("Canon imageClass MF756Cx", "printer001", studentThreads);

        // Student threads
        Student student1 = new Student("James Bond", printer, studentThreads);
        Student student2 = new Student("Tom Hardy", printer, studentThreads);
        Student student3 = new Student("Johnny English", printer, studentThreads);
        Student student4 = new Student("Jack Black", printer, studentThreads);
        Student student5 = new Student("Tom Sawyer", printer, studentThreads);

        // Technician threads
        PaperTechnician paperTechnician = new PaperTechnician("Jesse Pinkman", printer, technicianThreads);
        TonerTechnician tonerTechnician = new TonerTechnician("Walter White", printer, technicianThreads);

        // Starting and joining threads
        student1.start();
        student2.start();
        student3.start();
        student4.start();
        student5.start();

        paperTechnician.start();
        tonerTechnician.start();

        try {
            student1.join();
            student2.join();
            student3.join();
            student4.join();
            student5.join();
            paperTechnician.join();
            tonerTechnician.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n----END--------------------------------------------------------------------");
    }
}
