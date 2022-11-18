public class PrintingSystem {
    public static void main(String[] args) {
        ServicePrinter printer = new LaserPrinter("Ip-CG", 24, 150, 150, 0);

        ThreadGroup studentGroup = new ThreadGroup("Student Group");
        ThreadGroup techniciansGroup = new ThreadGroup("Technicians Group");

        Runnable studentRunnable1 = new Student("Thaveesha", studentGroup, printer);
        Runnable studentRunnable2 = new Student("Sherlock", studentGroup, printer);
        Runnable studentRunnable3 = new Student("Watson", studentGroup, printer);
        Runnable studentRunnable4 = new Student("Moriarty", studentGroup, printer);
        Runnable studentRunnable5 = new Student("Lestrade", studentGroup, printer);

        Thread studentThread1 = new Thread(studentGroup, studentRunnable1, "Thaveesha");
        Thread studentThread2 = new Thread(studentGroup, studentRunnable2, "Sherlock");
        Thread studentThread3 = new Thread(studentGroup, studentRunnable3, "Watson");
        Thread studentThread4 = new Thread(studentGroup, studentRunnable4, "Moriarty");
        Thread studentThread5 = new Thread(studentGroup, studentRunnable5, "Lestrade");

        Runnable paperTechnician = new PaperTechnician("Kevin", techniciansGroup, printer);
        Runnable tonerTechnician = new TonerTechnician("Ben", techniciansGroup, printer);

        Thread paperTechnicianThread = new Thread(techniciansGroup, paperTechnician, "Kevin");
        Thread tonerTechnicianThread = new Thread(techniciansGroup, tonerTechnician, "Ben");

        studentThread1.start();
        studentThread2.start();
        studentThread3.start();
        studentThread4.start();
        studentThread5.start();

        paperTechnicianThread.start();
        tonerTechnicianThread.start();
    }
}