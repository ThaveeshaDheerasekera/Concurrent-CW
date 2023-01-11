/**
 * *************************************************************
 * File:        Student.java (Class)
 * Author:      Thaveesha Dheerasekera; IIT ID: 2019483; UoW ID: w1761369
 * Contents:    6SENG006C Concurrent Programming Coursework (2022/23)
 * Description: This provides the thread behaviour of students.
 * Date:        06-Jan-23
 * Version:     1.0
 * *************************************************************
 */

public class Student extends Thread {
    private final Printer printer;   // printer
    private final String studentName;   // student's name

    Student(String studentName, Printer printer, ThreadGroup threadGroup) {
        super(threadGroup, "Thread:" + studentName);
        this.printer = printer;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
//            int documentNo = i + 1;     // To get the first document number as 1
            Document document = new Document(studentName, "Document [" + i + "]", (int) (Math.random() * 25));
            printer.printDocument(document);

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
