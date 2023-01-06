/**
 * *************************************************************
 * File:	Student.java (Class)
 * Author:	Thaveesha Dheerasekera; IIT ID: 2019483; UoW ID: w1761369
 * Contents:    Concurrent Programming Coursework (2022/23)
 * Description: This provides the thread behaviour of students.
 * Date:	06-Jan-23
 * Version:	1.0
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
        for (int i = 0; i < 5; i++) {
            Document CWK = new Document(studentName, "cwk" + i, (int) (Math.random() * 25));
            printer.printDocument(CWK);

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
